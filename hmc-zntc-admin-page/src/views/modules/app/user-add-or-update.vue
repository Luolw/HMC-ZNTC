<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="编号" prop="uuid">
      <el-input v-model="dataForm.uuid" placeholder="编号"></el-input>
    </el-form-item>
    <el-form-item label="用户名" prop="name">
      <el-input v-model="dataForm.name" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="pwd">
      <el-input v-model="dataForm.pwd" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item label="电话" prop="phone">
      <el-input v-model="dataForm.phone" placeholder="电话"></el-input>
    </el-form-item>
    <el-form-item label="头像" prop="photo">
      <el-input v-model="dataForm.photo" placeholder="头像"></el-input>
    </el-form-item>
    <el-form-item label="邮箱" prop="email">
      <el-input v-model="dataForm.email" placeholder="邮箱"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="0男1女" prop="sex">
      <el-input v-model="dataForm.sex" placeholder="0男1女"></el-input>
    </el-form-item>
    <el-form-item label="余额" prop="money">
      <el-input v-model="dataForm.money" placeholder="余额"></el-input>
    </el-form-item>
    <el-form-item label="状态(1正常 -1禁用)" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态(1正常 -1禁用)"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="新建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="新建时间"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          uuid: '',
          name: '',
          pwd: '',
          phone: '',
          photo: '',
          email: '',
          remark: '',
          sex: '',
          salt: '',
          money: '',
          status: '',
          updateTime: '',
          createTime: ''
        },
        dataRule: {
          uuid: [
            { required: true, message: '编号不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '用户名不能为空', trigger: 'blur' }
          ],
          pwd: [
            { required: true, message: '密码不能为空', trigger: 'blur' }
          ],
          phone: [
            { required: true, message: '电话不能为空', trigger: 'blur' }
          ],
          photo: [
            { required: true, message: '头像不能为空', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '邮箱不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '0男1女不能为空', trigger: 'blur' }
          ],
          salt: [
            { required: true, message: '盐不能为空', trigger: 'blur' }
          ],
          money: [
            { required: true, message: '余额不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态(1正常 -1禁用)不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '新建时间不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/app/user/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.uuid = data.user.uuid
                this.dataForm.name = data.user.name
                this.dataForm.pwd = data.user.pwd
                this.dataForm.phone = data.user.phone
                this.dataForm.photo = data.user.photo
                this.dataForm.email = data.user.email
                this.dataForm.remark = data.user.remark
                this.dataForm.sex = data.user.sex
                this.dataForm.salt = data.user.salt
                this.dataForm.money = data.user.money
                this.dataForm.status = data.user.status
                this.dataForm.updateTime = data.user.updateTime
                this.dataForm.createTime = data.user.createTime
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/app/user/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'uuid': this.dataForm.uuid,
                'name': this.dataForm.name,
                'pwd': this.dataForm.pwd,
                'phone': this.dataForm.phone,
                'photo': this.dataForm.photo,
                'email': this.dataForm.email,
                'remark': this.dataForm.remark,
                'sex': this.dataForm.sex,
                'salt': this.dataForm.salt,
                'money': this.dataForm.money,
                'status': this.dataForm.status,
                'updateTime': this.dataForm.updateTime,
                'createTime': this.dataForm.createTime
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
