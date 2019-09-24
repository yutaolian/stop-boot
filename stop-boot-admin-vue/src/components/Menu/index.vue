<template>
  <div class="menu-wrapper" style="width: 300px">
    <!--      <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">-->
    <!--        <el-radio-button :label="false">展开</el-radio-button>-->
    <!--        <el-radio-button :label="true">收起</el-radio-button>-->
    <!--      </el-radio-group>-->
    <el-menu router @open="handleOpen" @close="handleClose"
             :default-active="activeMenu"
             :collapse="isCollapse"
             :background-color="variables.menuBg"
             :text-color="variables.menuText"
             :unique-opened="false"
             :active-text-color="variables.menuActiveText"
             :collapse-transition="false"
             mode="vertical">

      <template v-for="proute in permission_routes">
        <template v-if="!proute.hidden">
          <template v-if="proute.children.length > 1">
            <el-submenu :index="proute.path">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span slot="title">{{proute.meta.title}}</span>
                <span slot="title">{{proute}}</span>
              </template>
              <template v-for="subroute in proute.children">
                <template v-if="!subroute.hidden ">
                  <template v-if="subroute.children == undefined || subroute.children.length == 0">
                    <el-menu-item :index="proute.path+'/'+subroute.path">
                      <span slot="title">{{subroute.meta.title}}</span>
                    </el-menu-item>
                  </template>
                  <template v-else>
                    <el-submenu index="1-4-1">
                      <span slot="title">选项41</span>
                      <el-menu-item index="1-4-1">选项1111</el-menu-item>
                    </el-submenu>
                  </template>
                </template>
              </template>
            </el-submenu>
          </template>
          <template v-else>
            <el-menu-item :index="proute.path">
              <i class="el-icon-menu"></i>
              <span slot="title">{{proute.meta.title}}</span>
            </el-menu-item>
          </template>
        </template>
      </template>


      <!--                <el-submenu index="1">-->
      <!--                  <template slot="title">-->
      <!--                    <i class="el-icon-location"></i>-->
      <!--                    <span slot="title">导航一</span>-->
      <!--                  </template>-->
      <!--                  <el-menu-item index="1-3">选项3</el-menu-item>-->
      <!--                  <el-submenu index="1-4">-->
      <!--                    <span slot="title">选项4</span>-->
      <!--                    <el-menu-item index="1-4-1">选项1</el-menu-item>-->
      <!--                    <el-submenu index="1-4-1">-->
      <!--                      <span slot="title">选项41</span>-->
      <!--                      <el-menu-item index="1-4-1">选项1111</el-menu-item>-->
      <!--                    </el-submenu>-->
      <!--                  </el-submenu>-->
      <!--                </el-submenu>-->

      <!--          <el-submenu index="5">-->
      <!--            <template slot="title">-->
      <!--              <i class="el-icon-location"></i>-->
      <!--              <span slot="title">导航一</span>-->
      <!--            </template>-->
      <!--            <el-menu-item index="1-4-1">选项1</el-menu-item>-->
      <!--          </el-submenu>-->

      <!--          <el-submenu index="51">-->
      <!--            <template slot="title">-->
      <!--              <i class="el-icon-location"></i>-->
      <!--            </template>-->
      <!--            <el-menu-item index="1-4-11">选项1</el-menu-item>-->
      <!--          </el-submenu>-->

    </el-menu>
  </div>
</template>

<script>
    import path from 'path'
    import {isExternal} from '@/utils'
    import {mapGetters} from 'vuex'
    import Logo from '@/components/Logo'
    import variables from '@/styles/variables.scss'

    export default {
        components: {Logo},
        computed: {
            ...mapGetters([
                'permission_routes',
                'sidebar'
            ]),
            activeMenu() {
                const route = this.$route
                const {meta, path} = route
                // if set path, the sidebar will highlight the path you set
                if (meta.activeMenu) {
                    return meta.activeMenu
                }
                return path
            },
            showLogo() {
                return this.$store.state.settings.sidebarLogo
            },
            variables() {
                return variables
            },
            isCollapse() {
                return !this.sidebar.opened
            },

        },
        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            },
            resolvePath(basePath, routePath) {
                if (this.isExternalLink(routePath)) {
                    return routePath
                }
                return path.resolve(basePath, routePath)
            },
            isExternalLink(routePath) {
                return isExternal(routePath)
            }
        }
    }
</script>
