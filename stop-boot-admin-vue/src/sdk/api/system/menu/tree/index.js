import {api} from '@/sdk/api/httpConfig'

export class MenuListRequest {
  constructor() {
    this.data = {
      userId: undefined,
      courseId: undefined
    }
  }

  setUserId(userId) {
    this.data.userId = userId
  }

  setCourseId(courseId) {
    this.data.courseId = courseId
  }
}

export class MenuListResponse {
  constructor(data) {
    this.data = data
  }

  getData() {
    return this.data
  }

  getTitle() {
    return this.data['title']
  }

  getName() {
    return this.data['name']
  }

  getPath() {
    return this.data['path']
  }

  getComponent() {
    return this.data['component']
  }

  getHidden() {
    return this.data['hidden']
  }

  getChildren() {
    let childrenTemp = this.data['children'];
    let children = []
    childrenTemp.forEach(res => {
      children.push(new MenuListResponse(res))
    })
    return children
  }

  getIcon() {
    return this.data['icon']
  }
}

export function menuTree(request) {
  var data = request.data
  // eslint-disable-next-line eqeqeq
  if (data['userId'] == undefined) {
    console.error('userId 参数不能为空')
  }
  const path = 'menu/tree'
  return new Promise(resolve => {
    api(path, data)
      .then(response => {
        let data = []
        response.forEach(res => {
          data.push(new MenuListResponse(res))
        })
        resolve(data)
      })
  })
}



/*
//引用链接
import {TestPageRequest, testPage} from '@/sdk/api/test/test1/page'

//使用方法
let request = new TestPageRequest()
request.setPageNum(this.listQuery.pageNum)
request.setPageSize(this.listQuery.pageSize)
testPage(request).then(res => {
  this.listLoading = false
  this.list = res['list']
  this.total = res['total']
})

*/
