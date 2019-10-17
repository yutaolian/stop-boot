import {api} from '@/sdk/api/httpConfig'

<<<<<<< HEAD
export class MenuAddRequest {
=======
export class MenuListRequest {
>>>>>>> 50f55a0781fbdf33fb04f6197c0ebb5c57450ef4
  constructor() {
    this.data = {
      pid: undefined,
      title: undefined,
      name: undefined,
      component: undefined,
      path: undefined,
      icon: undefined,
      type: undefined,
      hidden: undefined,
      sort: undefined
    }
  }

  setPid(pid) {
    this.data.pid = pid
  }

  setTitle(title) {
    this.data.title = title
  }

  setName(name) {
    this.data.name = name
  }

  setComponent(component) {
    this.data.component = component
  }

  setPath(path) {
    this.data.path = path
  }

  setIcon(icon) {
    this.data.icon = icon
  }

  setType(type) {
    this.data.type = type
  }

  setHidden(hidden) {
    this.data.hidden = hidden
  }

  setSort(sort) {
    this.data.sort = sort
  }
}

<<<<<<< HEAD
export function menuAdd(request) {
=======
export function menuList(request) {
>>>>>>> 50f55a0781fbdf33fb04f6197c0ebb5c57450ef4
  let data = request.data
  const path = 'system/menu/add'
  return new Promise(resolve => {
    api(path, data)
      .then(response => {
        resolve(response)
      })
  })
}
