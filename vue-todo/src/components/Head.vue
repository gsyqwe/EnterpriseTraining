<template>
    <div>
        <ul>
            <li><router-link to="/">首页</router-link></li>
            <li><router-link to="/movie">电影</router-link></li>
            <li><router-link to="/music">音乐</router-link></li>
        </ul>
        <div class="clear"></div>
    </div>
</template>

<script>
    export default {

    }
</script>

<style scoped>

    ul {
        height: 50px;
        list-style: none;
        clear: both;
        background-color: brown;
    }

    li{
        float: left;
        width: 100px;
        line-height: 50px;
        color: #fff;
    }

    li a {
        text-decoration: none;
        color: #fff;
    }

    .clear {
        clear: both
    }
</style>