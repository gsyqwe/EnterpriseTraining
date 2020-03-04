<template>
    <div>
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <h2><span>{{record.info.rankname}}</span></h2>
                <p class="remark"><span>{{record.info.intro}}</span></p>
            </div>
            <div v-for="o in record.songs.list" :key="o" class="text item">
                <span @click="handlePlay(o.hash)">{{o.filename}}</span>
            </div>
        </el-card>
    </div>
</template>

<script>
    import axios from 'axios'
    export default {
        data(){
            return{
                rankId: '',
                record: {}
            }
        },
        created(){
            //取参数id的值
            this.rankId = this.$route.params.id
            this.getData()
        },
        methods:{
            getData(){
               let url=`https://bird.ioliu.cn/v1?url=http://m.kugou.com/rank/info/?rankid=${this.rankId}&page=1&json=true`
                axios.get(url).then((res)=>{
                    this.record = res.data
                })
            },
            handlePlay(hash){
                let url=`https://bird.ioliu.cn/v1?url=https://www.kugou.com/yy/index.php?r=play/getdata&hash=${hash}`
                console.log(url)
                //let url=`https://bird.ioliu.cn/v1?url=http://m.kugou.com/api/v1/song/get_song_info?cmd=playInfo&hash=${hash}&from=mkugou&apiver=2&mid=1&userid=0&platid=5&dfid=null`
                axios.get(url).then((res)=>{
                    console.log(res)
                })
            }
        }
    }
</script>

<style scoped>
    .remark {
        font-size: 14px;
        color: #ccc;
    }

    .text {
        font-size: 14px;
    }

    .item {
        margin-bottom: 18px;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }
    .clearfix:after {
        clear: both
    }

    .box-card {
        width: 480px;
    }
</style>