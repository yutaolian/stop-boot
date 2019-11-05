<template>
  <div>
    <template v-if="!item.hidden">
      <template v-if="item.children == undefined || item.children.length == 0">
        <el-menu-item :index="resolvePath(item.path)">
          <i class="el-icon-location"></i>
          <span slot="title">{{item.meta.title}}</span>
        </el-menu-item>
      </template>
      <template v-else>
        <el-submenu :index="resolvePath(item.path)">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span slot="title">{{item.meta.title}}</span>
          </template>
          <sub-menu-item v-for="subroute in item.children" :key="subroute.path"
                         :item="subroute" :parent="item"
                         :base-path="basePath+'/'+item.path"></sub-menu-item>
        </el-submenu>
      </template>
    </template>
  </div>
</template>

<script>
    import path from 'path'
    import {isExternal} from '@/utils/validate'

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
                // console.log("this.basePath", this.basePath, "routePath", routePath, "path", path.resolve(this.basePath, routePath))
                return path.resolve(this.basePath, routePath)
            }
        }
    }
</script>
