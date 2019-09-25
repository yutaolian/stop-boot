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
      <sub-menu v-for="item in permission_routes" :key="item.name" :item="item" :base-path="item.path" ></sub-menu>
    </el-menu>
  </div>
</template>
<script>
    import path from 'path'
    import {isExternal} from '@/utils'
    import {mapGetters} from 'vuex'
    import Logo from '@/components/Logo'
    import variables from '@/styles/variables.scss'
    import SubMenu from '@/components/SubMenu'

    export default {
        components: {Logo, SubMenu},
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
