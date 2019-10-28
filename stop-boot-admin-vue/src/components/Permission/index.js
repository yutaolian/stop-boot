import Vue from 'vue'
// 删除节点dom
const remove = (el) => el.parentNode.removeChild(el)

const permission = Vue.directive('permission', {
  inserted: (el, binding, vNode) => {
    let {value} = binding
    // 判断条件：当传入的值不是数组或者字符串时，直接隐藏元素 string 和 array
    if (!(typeof value === 'string' || value instanceof Array) || !value) {
      remove(el)
    }
    // 判断条件：如果传入的权限码是string则转化成数组
    if (typeof value === 'string') {
      value = [value]
    }
    /**
     * 判断条件
     * access 为用户菜单拥有的权限列表
     */
    let access = vNode.context.$route.meta.permission;
    console.log("access====",access);
    if (value.some(v => !access.includes(v))) {
      remove(el)
    }
  }
})

export default permission
