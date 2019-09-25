<template>
  <div>
    <template v-if="!item.hidden">
      <template v-if="item.children.length > 0 && item.meta.title.indexOf('parent')">
        <el-submenu :index="resolvePath(item.path)">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span slot="title">{{item.meta.title}}</span>
          </template>
          <template v-for="subroute in item.children">
            <template v-if="!subroute.hidden ">
              <template v-if="subroute.children == undefined || subroute.children.length == 0">
                <el-menu-item :index="resolvePath(subroute.path)">
                  <span slot="title">{{subroute.meta.title}}</span>
                </el-menu-item>
              </template>
              <template v-else>
                <sub-menu-item v-for="subroute2 in subroute.children" :key="subroute.name"
                               :item="subroute2" :parent="subroute" :base-path="subroute.path"></sub-menu-item>
              </template>
            </template>
          </template>
        </el-submenu>
      </template>
      <template v-else>
        <template v-for="subroute in item.children">
          <template v-if="!subroute.hidden ">
            <el-menu-item :index="resolvePath(subroute.path)">
              <i class="el-icon-setting"></i>
              <span slot="title">{{subroute.meta.title}}</span>
            </el-menu-item>
          </template>
        </template>
      </template>
    </template>

  </div>
</template>

<script>
    import path from 'path'
    import SubMenuItem from '@/components/SubMenuItem'
    import { isExternal } from '@/utils/validate'
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
                return path.resolve(this.basePath, routePath)
            }
        }
    }
</script>
