//字典接口
import {DictionaryListRequest} from '@/sdk/api/system/dictionary/list'

export default {
  data(){
    return {
      dictValueMap: {

      }
    }
  },
  created() {
    // this.loadDictValue();
  },
  methods: {
    loadDictValue(dicKey) {
      // if (dicKey){
        let request = new DictionaryListRequest()
        request.setDicKey(dicKey).api().then(res =>{
          this.$set(this.dictValueMap, dicKey, res)
        })
      // }
    }
  }
};
