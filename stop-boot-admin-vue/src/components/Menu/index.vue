<template>
  <div class="menu-wrapper">
    <el-menu router @open="handleOpen" @close="handleClose"
             :default-active="activeMenu"
             :collapse="isCollapse"
             :background-color="variables.menuBg"
             :text-color="variables.menuText"
             :unique-opened="true"
             :active-text-color="variables.menuActiveText"
             :collapse-transition="false"
             mode="vertical">
      <sub-menu v-for="item in menuRoutes" :key="item.name" :item="item" :base-path="item.path"></sub-menu>
    </el-menu>
    <!--    <el-menu router @open="handleOpen" @close="handleClose"-->
    <!--             :default-active="activeMenu"-->
    <!--             :collapse="isCollapse"-->
    <!--             :background-color="variables.menuBg"-->
    <!--             :text-color="variables.menuText"-->
    <!--             :unique-opened="true"-->
    <!--             :active-text-color="variables.menuActiveText"-->
    <!--             :collapse-transition="false"-->
    <!--             mode="vertical">-->
    <!--      <NavMenu :navMenus="permission_routes"></NavMenu>-->
    <!--    </el-menu>-->
  </div>
</template>
<script>
    import NavMenu from "@/components/NavMenu.vue";
    import path from 'path'
    import {isExternal} from '@/utils'
    import {mapGetters} from 'vuex'
    import Logo from '@/components/Logo'
    import variables from '@/styles/variables.scss'
    import SubMenu from '@/components/SubMenu'

    export default {
        components: {Logo, SubMenu, NavMenu},
        computed: {
            ...mapGetters([
                'menuRoutes',
                'sidebar'
            ]),
            activeMenu() {
                const route = this.$route
                const {meta, path} = route
                // if set path, the sidebar will highlight the path you set

                console.log("route",route)
                console.log("meta",meta)
                console.log("meta.type",meta.type)
                if (meta.type === 1) {
                    return path
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
