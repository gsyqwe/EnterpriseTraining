<template>
    <div>
        <figure v-for="(item,index) in records" :key="index">
            <img :src="item.images.small" @click="handleDetail(item.id)"/>
            <h2 @click="handleDetail(item.id)">{{item.title}}</h2>
            <p class="pub-date">上映日期:{{item.mainland_pubdate}}</p>
            <p class="rating">评分: {{item.rating.average}}</p>
        </figure>

        <div class="clear"></div>
    </div>
</template>

<script>
    import axios from 'axios'
    export default {
        data(){ //定义数据
            return {
                records: []
            }
        },
        //实始化完自动执行
        created(){
            let url = 'https://bird.ioliu.cn/v1?url=https://api.douban.com/v2/movie/in_theaters?apikey=0b2bdeda43b5688921839c8ecb20399b'
            axios.get(url).then((res)=>{
                this.records = res.data.subjects
                console.log(this.records)

            })
        },
        methods:{
            //跳转
            handleDetail(id){
                //跳转的路由是detail,传递参数id
                this.$router.push({
                    path: `/detail/${id}`
                })
            }
        }
    }
</script>

<style scoped>
    figure {
        width: 212px;
        float: left;
        padding:2px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    figure img {
        width: 210px;
        height: 299px;
    }

    figure h2 {
        text-align: center;
        font-size: 22px;
        color: #666;
        white-space: nowrap;/* 不换行*/
        overflow: hidden;/* 超出不显示*/
        text-overflow:ellipsis;/* 加省略号显示*/
    }

    figure .pub-date {
        text-align: center;
        color: #bdbdbd;

    }

    figure .rating {
        text-align: center;
        color: darkorange;
    }
    .clear {
        clear: both
    }
</style>