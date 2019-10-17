import {api} from '@/sdk/api/httpConfig'

export class MenuListRequest {
    constructor() {
    this.data = {
        pid: undefined
    }
}

    setPid(pid) {
        this.data.pid = pid
    }

}

export function menuList(request) {
    let data = request.data
    const path = 'system/menu/add'
    return new Promise(resolve => {
        api(path, data)
        .then(response => {
            resolve(response)
        })
    })
}
