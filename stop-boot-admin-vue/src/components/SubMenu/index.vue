<template>
  <div>
    <template v-if="!item.hidden">
      <!--一级节点有子节点-->
      <template
        v-if="item.children.length > 0 && item.meta.title.indexOf(this.$store.state.settings.routerParentPrifix)">
        <el-submenu :index="resolvePath(item.path)">
          <template slot="title">
            <i :class="item.meta.icon"></i>
            <span slot="title">{{item.meta.title}}</span>
          </template>
          <template v-for="subroute in item.children">
            <template v-if="!subroute.hidden ">
              <!--二级节点无子节点-->
              <template v-if="subroute.children == undefined || subroute.children.length == 0">
                <template v-if="subroute.meta.type != 2">
                  <el-menu-item :index="resolvePath(subroute.path)">
                    <i :class="subroute.meta.icon"></i>
                    <span slot="title">{{subroute.meta.title}}</span>
                  </el-menu-item>
                </template>
                <template v-else>
                  <el-menu-item>
                    <i :class="subroute.meta.icon"></i>
                    <a :href="subroute.path" target="_blank">{{subroute.meta.title }}</a>
<!--                    <router-link :to="subroute.path" target="_blank">{{subroute.meta.title }}</router-link>-->
                  </el-menu-item>
                </template>
              </template>
              <!-- 二级节点是有子节点-->
              <template v-else>
                <el-submenu :index="resolvePath(subroute.path)">
                  <template slot="title">
                    <i :class="subroute.meta.icon"></i>
                    <span slot="title">{{subroute.meta.title}}</span>
                  </template>
                  <sub-menu-item v-for="subSubroute in subroute.children" :key="subSubroute.path"
                                 :item="subSubroute" :base-path="subSubroute.path"></sub-menu-item>
                </el-submenu>
              </template>
            </template>
          </template>
        </el-submenu>
      </template>
      <template v-else>
        <!-- 一级节点无子节点-->
        <template v-for="subroute in item.children">
          <template v-if="!subroute.hidden ">
            <template v-if="subroute.meta.type != 2">
              <el-menu-item :index="resolvePath(subroute.path)">
                <i :class="subroute.meta.icon"></i>
                <span slot="title">{{subroute.meta.title}}</span>
              </el-menu-item>
            </template>
            <template v-else>
              <el-menu-item>
                <i :class="subroute.meta.icon"></i>
                <a :href="subroute.path" target="_blank">{{subroute.meta.title }}</a>
<!--                <router-link :to="subroute.path" target="_blank">{{subroute.meta.title }}</router-link>-->
              </el-menu-item>
            </template>
          </template>
        </template>
      </template>
    </template>

  </div>
</template>

<script>
    import path from 'path'
    import SubMenuItem from '@/components/SubMenuItem'
    import {isExternal} from '@/utils/validate'

    export default {
        name: 'SubMenu',
        components: {SubMenuItem},
        props: {
            // route object
            item: {
                type: Object,
                required: true
            },
            isNest: {
                type: Boolean,
                default: false
            },
            basePath: {
                type: String,
                default: ''
            }
        },
        methods: {
            resolvePath(routePath) {
                if (isExternal(routePath)) {
                    return routePath
                }
                if (isExternal(this.basePath)) {
                    return this.basePath
                }
                return path.resolve(routePath)
            }
        }
    }
</script>
