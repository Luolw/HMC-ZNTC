<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="资源ID" prop="uuid">
      <el-input v-model="dataForm.uuid" placeholder="资源ID"></el-input>
    </el-form-item>
    <el-form-item label="-1禁止 0正常 " prop="status">
      <el-input v-model="dataForm.status" placeholder="-1禁止 0正常 "></el-input>
    </el-form-item>
    <el-form-item label="广告来源" prop="orgin">
      <el-input v-model="dataForm.orgin" placeholder="广告来源"></el-input>
    </el-form-item>
    <el-form-item label="开始时间" prop="startTime">
      <el-input v-model="dataForm.startTime" placeholder="开始时间"></el-input>
    </el-form-item>
    <el-form-item label="结束时间" prop="endTime">
      <el-input v-model="dataForm.endTime" placeholder="结束时间"></el-input>
    </el-form-item>
    <el-form-item label="一体机数量" prop="count">
      <el-input v-model="dataForm.count" placeholder="一体机数量"></el-input>
    </el-form-item>
    <el-form-item label="曝光次数" prop="playTimes">
      <el-input v-model="dataForm.playTimes" placeholder="曝光次数"></el-input>
    </el-form-item>
    <el-form-item label="轮播速度" prop="playSpeed">
      <el-input v-model="dataForm.playSpeed" placeholder="轮播速度"></el-input>
    </el-form-item>
    <el-form-item label="颜色" prop="color">
      <el-input v-model="dataForm.color" placeholder="颜色"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
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
          status: '',
          orgin: '',
          startTime: '',
          endTime: '',
          count: '',
          playTimes: '',
          playSpeed: '',
          color: '',
          remark: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          uuid: [
            { required: true, message: '资源ID不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '-1禁止 0正常 不能为空', trigger: 'blur' }
          ],
          orgin: [
            { required: true, message: '广告来源不能为空', trigger: 'blur' }
          ],
          startTime: [
            { required: true, message: '开始时间不能为空', trigger: 'blur' }
          ],
          endTime: [
            { required: true, message: '结束时间不能为空', trigger: 'blur' }
          ],
          count: [
            { required: true, message: '一体机数量不能为空', trigger: 'blur' }
          ],
          playTimes: [
            { required: true, message: '曝光次数不能为空', trigger: 'blur' }
          ],
          playSpeed: [
            { required: true, message: '轮播速度不能为空', trigger: 'blur' }
          ],
          color: [
            { required: true, message: '颜色不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/app/advert/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.uuid = data.advert.uuid
                this.dataForm.status = data.advert.status
                this.dataForm.orgin = data.advert.orgin
                this.dataForm.startTime = data.advert.startTime
                this.dataForm.endTime = data.advert.endTime
                this.dataForm.count = data.advert.count
                this.dataForm.playTimes = data.advert.playTimes
                this.dataForm.playSpeed = data.advert.playSpeed
                this.dataForm.color = data.advert.color
                this.dataForm.remark = data.advert.remark
                this.dataForm.createTime = data.advert.createTime
                this.dataForm.updateTime = data.advert.updateTime
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
              url: this.$http.adornUrl(`/app/advert/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'uuid': this.dataForm.uuid,
                'status': this.dataForm.status,
                'orgin': this.dataForm.orgin,
                'startTime': this.dataForm.startTime,
                'endTime': this.dataForm.endTime,
                'count': this.dataForm.count,
                'playTimes': this.dataForm.playTimes,
                'playSpeed': this.dataForm.playSpeed,
                'color': this.dataForm.color,
                'remark': this.dataForm.remark,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime
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
