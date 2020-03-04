<template>
    <div>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="用户名" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>

            <el-form-item label="生日" prop="birthday">
                <el-col :span="11">
                    <el-form-item >
                        <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.birthday" style="width: 100%;"></el-date-picker>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item label="性别">
                <el-radio-group v-model="ruleForm.sex">
                    <el-radio label="0">男</el-radio>
                    <el-radio label="1">女</el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="成绩" prop="score">
                <el-input type="text" v-model="ruleForm.score"></el-input>
            </el-form-item>
            <el-form-item label="地址" prop="address">
                <el-input type="text" v-model="ruleForm.address"></el-input>
            </el-form-item>
            <el-form-item label="照片">
                <el-upload
                        class="avatar-uploader"
                        action="http://localhost:8999/ss/upload"
                        :show-file-list="false"
                        :on-success="handleAvatarSuccess"
                        >
                    <img v-if="imageUrl" :src="`http://localhost:8999/ss/${imageUrl}`" class="avatar">
                    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
                <el-button type="primary" @click="handleBack">返回</el-button>
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
                    name: '',
                    sex: '0',
                    birthday: '',
                    score: 0,
                    address: '',
                    photo: ''
                },
                imageUrl: '',
                rules: {
                    name: [
                        { required: true, message: '请输入用户名', trigger: 'blur' },
                    ],
                    birthday: [
                        { required: true, message: '请选择生日', trigger: 'blur' },
                    ],
                    score:[
                        {required: true,message:'请输入成绩',trigger: 'blur'},
                        { pattern: /^\d+$|^\d+[.]?\d+$/,message: '必须是数字'}
                    ],
                }
            }
        },
        methods: {
            submitForm(formName){
                this.$refs[formName].validate((valid) => {
                    if (valid) { //校验成功
                        //提交
                        let url = 'http://localhost:8999/ss/student/add'
                        axios.post(url,this.ruleForm).then((res)=>{
                            if(res.data === 'succ'){
                                this.$message('操作成功')
                            }else{
                                this.$message('操作失败')
                            }
                        })
                    }
                });

            },
            handleBack(){
                this.$router.push("/")
            },
            handleAvatarSuccess(res) {
                //console.log(res)
                this.imageUrl = res;
                this.ruleForm.photo = res
                //console.log(this.imageUrl)
            }
        }
    }
</script>

<style scoped>
    .avatar-uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }
    .avatar-uploader .el-upload:hover {
        border-color: #409EFF;
    }
    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 178px;
        height: 178px;
        line-height: 178px;
        text-align: center;
    }
    .avatar {
        width: 178px;
        height: 178px;
        display: block;
    }
</style>