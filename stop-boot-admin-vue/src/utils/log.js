// 应用发布时为true,开发阶段为false
// 很轻松的取消日志
let idDebugger = false;

const  Log = (Vue) => {
  Vue.prototype.$log = new Vue({
    methods:{
      // 强烈日志...
      error(...params){
        if (!idDebugger) {
          console.log('❌···',...params);
        }
      },

      // 普通日志...
      info(...params){
        if (!idDebugger) {
          console.log(...params);
        }
      },
    }
  });
};

export default Log;
