<template>
  <div :class="{'has-logo':showLogo}">
<!--    <logo v-if="showLogo" :collapse="isCollapse"/>-->
    <el-scrollbar wrap-class="scrollbar-wrapper">

      <el-menu
        :default-active="activeMenu"
        :collapse="isCollapse"
        :background-color="variables.menuBg"
        :text-color="variables.menuText"
        :unique-opened="false"
        :active-text-color="variables.menuActiveText"
        :collapse-transition="false"
        mode="vertical"
      >
                <sidebar-item v-for="route in permission_routes" :key="route.path" :item="route" :base-path="route.path" />

      </el-menu>
<!--      <Menu></Menu>-->

    </el-scrollbar>
  </div>
</template>
<style>
</style>
<script>
    import {mapGetters} from 'vuex'
    import Logo from '@/components/Logo'
    import SidebarItem from '@/components/SidebarItem'
    import variables from '@/styles/variables.scss'
    import Menu from '@/components/Menu'

    export default {
        components: {SidebarItem, Logo, Menu},
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
            }
        },

        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            }
        }
    }
</script>
