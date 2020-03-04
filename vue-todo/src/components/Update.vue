<template>
    <div>
        <el-form :model="ruleForm" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="用户名" prop="name" required>
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>

            <el-form-item label="生日" required>
                <el-col :span="11">
                    <el-form-item prop="date1">
                        <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.birthday" style="width: 100%;"></el-date-picker>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item label="性别" prop="resource">
                <el-radio-group v-model="ruleForm.sex">
                    <el-radio label="0">男</el-radio>
                    <el-radio label="1">女</el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="成绩" prop="desc">
                <el-input type="text" v-model="ruleForm.score"></el-input>
            </el-form-item>
            <el-form-item label="地址" prop="desc">
                <el-input type="text" v-model="ruleForm.address"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    import axios from 'axios'
    export default {
        data(){
            return {
                ruleForm: {
                    id: 0,
                    name: '',
                    sex: '0',
                    birthday: '',
                    score: 0,
                    address: ''
                }
            }
        },
        created(){
            this.ruleForm.id = this.$route.params.id
            this.getData()
        },
        methods: {
            getData(){
                let url = `http://localhost:8999/ss/student/get/${this.ruleForm.id}`
                axios.get(url).then((res)=>{
                    this.ruleForm = res.data
                })
            },
            submitForm(formName){
                console.log(formName)
                //提交
                let url = 'http://localhost:8999/ss/student/update'
                axios.post(url,this.ruleForm).then((res)=>{
                    if(res.data === 'succ'){
                        this.$message('操作成功')
                    }else{
                        this.$message('操作失败')
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>