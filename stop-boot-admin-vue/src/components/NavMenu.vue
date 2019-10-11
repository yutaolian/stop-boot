<template>
  <div class="navMenu">

    <!--    <template v-for="navMenu in navMenus">-->
    <!--        &lt;!&ndash; 最后一级菜单 &ndash;&gt;-->
    <!--      <el-menu-item v-if="!navMenu.childs&&navMenu.entity"-->
    <!--                    :key="navMenu.entity.id" :data="navMenu" :index="navMenu.entity.name" -->
    <!--                   >-->
    <!--        <i :class="navMenu.entity.icon"></i>-->
    <!--        <span slot="title">{{navMenu.entity.alias}}</span>-->
    <!--      </el-menu-item>-->

    <!--      &lt;!&ndash; 此菜单下还有子菜单 &ndash;&gt;-->
    <!--      <el-submenu v-if="navMenu.childs&&navMenu.entity"-->
    <!--                  :key="navMenu.entity.id" :data="navMenu" :index="navMenu.entity.name">-->
    <!--        <template slot="title">-->
    <!--          <i :class="navMenu.entity.icon"></i>-->
    <!--          <span> {{navMenu.entity.alias}}</span>-->
    <!--        </template>-->
    <!--        &lt;!&ndash; 递归 &ndash;&gt;-->
    <!--        <NavMenu :navMenus="navMenu.childs"></NavMenu>-->
    <!--      </el-submenu>-->
    <!--    </template>-->

    <!--    <template-->
    <!--      v-if="item.children.length > 0 && item.meta.title.indexOf(this.$store.state.settings.routerParentPrifix)">-->
    <!--      <el-submenu :index="resolvePath(item.path)">-->
    <!--        <template slot="title">-->
    <!--          <i class="el-icon-location"></i>-->
    <!--          <span slot="title">{{item.meta.title}}</span>-->
    <!--        </template>-->
    <!--        <template v-for="subroute in item.children">-->
    <!--          <template v-if="!subroute.hidden ">-->
    <!--            &lt;!&ndash;二级节点无子节点&ndash;&gt;-->
    <!--            <template v-if="subroute.children == undefined || subroute.children.length == 0">-->
    <!--              <el-menu-item :index="resolvePath(subroute.path)">-->
    <!--                <span slot="title">{{subroute.meta.title}}</span>-->
    <!--              </el-menu-item>-->
    <!--            </template>-->
    <!--            &lt;!&ndash; 二级节点是有子节点&ndash;&gt;-->
    <!--            <template v-else>-->
    <!--              <el-submenu :index="resolvePath(subroute.path)" >-->
    <!--                <template slot="title">-->
    <!--                  <i class="el-icon-location"></i>-->
    <!--                  <span slot="title">{{subroute.meta.title}}</span>-->
    <!--                </template>-->
    <!--                <sub-menu-item v-for="subSubroute in subroute.children" :key="subSubroute.path"-->
    <!--                               :item="subSubroute" :parent="subroute"-->
    <!--                               :base-path="basePath+'/'+subroute.path" :route=resolvePath(subroute.path)></sub-menu-item>-->
    <!--              </el-submenu>-->
    <!--            </template>-->
    <!--          </template>-->
    <!--        </template>-->
    <!--      </el-submenu>-->
    <!--    </template>-->

    <template v-for="navMenu in navMenus">
      <!-- 最后一级菜单 -->
      <el-menu-item v-if="(navMenu.children == undefined || navMenu.children.length == 0) && !navMenu.hidden"
                    :key="navMenu.path" :data="navMenu" :index="resolvePath(navMenu.path)"
      >
        <i class="el-icon-location"></i>
        <span slot="title">{{navMenu.meta.title}}</span>
      </el-menu-item>
      <!-- 此菜单下还有子菜单 -->
      <el-submenu v-if="navMenu.children != undefined && navMenu.children.length > 0 && !navMenu.hidden"
                  :key="navMenu.path" :data="navMenu" :index="resolvePath(navMenu.path)">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span> {{navMenu.meta.title}}</span>
        </template>
        <!-- 递归 -->
        <NavMenu :navMenus="navMenu.children" :basePath="parent.path+'/'+navMenu.path" :parent="navMenu"></NavMenu>
      </el-submenu>
    </template>

  </div>
</template>

<script>
    import path from 'path'
    import {isExternal} from '@/utils/validate'

    export default {
        name: 'NavMenu',
        props: {
            // route object
            navMenus: {
                type: Array,
                required: true
            },
            parent: {
                type: Object,
                required: true
            },
            basePath: {
                type: String,
                default: ''
            }
        },
        data() {
            return {}
        },
        methods: {
            resolvePath(routePath) {
                if (isExternal(routePath)) {
                    return routePath
                }
                if (isExternal(this.basePath)) {
                    return this.basePath
                }
                return path.resolve(this.basePath,routePath)
            }
        }
    }
</script>

<style>
</style>
