<template>
    <div>
        这是详情
        {{id}}
    </div>
</template>

<script>
    import axios from 'axios'
    export default {
        data(){
          return {
              id: '',
              record: {}
          }
        },
        created(){
            //取参数id的值
            this.id = this.$route.params.id
            this.getData()
        },
        methods:{
            getData(){
                let url = `https://bird.ioliu.cn/v1?url=https://api.douban.com/v2/movie/subject/${this.id}?apikey=0b2bdeda43b5688921839c8ecb20399b`

                console.log(url)
                axios.get(url).then((res)=>{
                    this.record = res.data
                    console.log(this.record)
                })
            }
        }
    }
</script>

<style scoped>

</style>