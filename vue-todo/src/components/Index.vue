<template>
    <div>
        <el-button type="primary" @click="handleAdd">新增</el-button>
        <el-table
                v-loading="loading"
                :data="pageInfo.list"
                border
                style="width: 100%">
            <el-table-column
                    prop="name"
                    label="姓名"
                    width="180">
            </el-table-column>
            <el-table-column
                    label="性别"
                    width="180">
                <template scope="scope">
                    <span>{{scope.row.sex==='0'?'男':'女'}}</span>
                </template>
            </el-table-column>

            <el-table-column
                    prop="birthday"
                    label="生日"
                    width="400"
                    :formatter="dateFormatter"
            >
            </el-table-column>
            <el-table-column
                    label="照片"
                    width="180">
                <template scope="scope">
                    <img v-if="scope.row.photo" :src="`http://localhost:8999/ss/${scope.row.photo}`" class="photo"/>
                </template>
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button
                            size="mini"
                            @click="handleEdit(scope.row.id)">编辑</el-button>
                    <el-button
                            size="mini"
                            type="danger"
                            @click="handleDelete(scope.row.id)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <!--page-size	每页显示条目个数，支持 .sync 修饰符	number	—	10
total	总条目数
current-change	currentPage 改变时会触发-->
        <el-pagination
                background
                layout="prev, pager, next"
                @current-change="handleCurrentChange"
                :current-page="currPage"
                :page-size="pageInfo.pageSize"
                :total="pageInfo.total"
        >
        </el-pagination>
    </div>
</template>

<script>
    import axios from 'axios'
    import {makeDate} from '../static/js/dateformat'
    export default {
        data(){
            return{
                currPage: 1, //当前页,
                loading: false,
                pageInfo: {

                }
            }
        },
        created(){
            this.getData()
        },
        methods: {
            getData(){
                this.loading = true;
                let url = `http://localhost:8999/ss/student/query/${this.currPage}`
                axios.get(url).then((res)=>{
                    //console.log(res)
                    this.pageInfo = res.data
                    console.log(this.pageInfo)
                    this.loading = false;
                })
            },
            //格式化日期
            dateFormatter(row, column, cellValue){
                //console.log(cellValue)
                return makeDate(cellValue)
            },
            handleAdd(){
                this.$router.push("/add")
            },
            handleDelete(id){
                let url = `http://localhost:8999/ss/student/del/${id}`
                axios.post(url).then((res)=>{
                    if(res.data === 'succ'){
                        this.getData()
                        this.$message('操作成功')

                    }else{
                        this.$message('操作失败')
                    }
                })
            },
            handleEdit(id){
                //跳转的路由是update,传递参数id
                this.$router.push({
                    path: `/update/${id}`
                })
            },
            //val:跳转到的哪一页
            handleCurrentChange(val){
                this.currPage = val
                this.getData()
            }

        }
    }
</script>

<style scoped>
    .photo {
        width: 80px;
        height: 100px;
    }


</style>