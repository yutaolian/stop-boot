<template>
  <div>
    <template v-if="parent != null">
      <el-submenu :index="resolvePath(parent.path)">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span slot="title">{{parent.meta.title}}</span>
        </template>
        <sub-menu-item v-for="subroute in item.children" :key="item.name" :item="subroute"
                       :parent="item"></sub-menu-item>
        <template v-if="item.children == undefined || item.children.length == 0">
          <el-menu-item :index="resolvePath(item.path)">
            <span slot="title">{{item.meta.title}}</span>
          </el-menu-item>
        </template>
      </el-submenu>
    </template>
  </div>
</template>

<script>
    import path from 'path'
    import { isExternal } from '@/utils/validate'
    export default {
        name: 'SubMenuItem',
        props: {
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
            },
            parent: {
                type: Object,
                required: true
            },
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
