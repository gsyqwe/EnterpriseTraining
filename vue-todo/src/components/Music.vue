<template>
    <div>
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span>排行榜</span>
            </div>
            <div v-for="o in records" :key="o" class="text item">
                <img :src="o.imgurl.replace('{size}','400')" @click="handleDetail(o.rankid)"/>
                <span class="title" @click="handleDetail(o.rankid)"><el-tag type="success">{{o.rankname }}</el-tag></span>
            </div>
        </el-card>
    </div>
</template>

<script>
    import axios from 'axios'
    export default {
        data(){
            return{
                records: []
            }
        },
        created(){
            this.getData()
        },
        methods: {
            getData(){
                let url = "https://bird.ioliu.cn/v1?url=http://m.kugou.com/rank/list&json=true";
                axios.get(url).then((res)=>{
                    this.records = res.data.rank.list
                    console.log(this.records)
                })
            },
            //跳转
            handleDetail(id){
                //跳转的路由是detail,传递参数id
                this.$router.push({
                    path: `/rank/${id}`
                })
            }
        }

    }
</script>

<style scoped>
    .text {
        font-size: 14px;
    }

    .item {
        position: relative;
        margin-bottom: 18px;
    }

    .item img {
        width: 200px;
        height: 200px;
    }

    .item .title {
        position: absolute;
        top: 50%;
        left: 50%
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