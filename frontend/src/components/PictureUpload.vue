<template>
  <div>
    <uploader
      browse_button="browse_button"
      :url="server_config.url+'/File/'"
      :FilesAdded="filesAdded"
      @inputUploader="inputUploader"
    />
    <el-button id="browse_button" type="primary">选择图片</el-button>
    <br/>
    <br/>
    <el-row>
      <el-col :span="4" v-for="(file, index) in files" :key="index" :offset="index > 0 ? 1 : 0">
        <el-card :body-style="{ padding: '0px' }">
          <img v-if="file.imgsrc != null" width="240px" height="240px" :src="file.imgsrc" class="image">
          <div style="padding: 14px;">
              <el-button type="text" class="button" @click="up.removeFile(file)">删除</el-button>
          </div>
        </el-card>
      </el-col>
    </el-row>
    <br/>
    <el-button type="danger" @click="up.start()">开始上传</el-button>
  </div>
</template>

<script>
  import Uploader from './Uploader'
  import FileUrl from '../models/file-url'

  export default {
    name: "PictureUpload",
    data() {
      return {
        server_config: this.global.server_config,
        files:[],
        up: {},
      }
    },
    components: {
      'uploader': Uploader
    },
    methods: {
      inputUploader(up) {
        this.up = up;
        this.files = up.files;
      },
      filesAdded(up, files) {
        files.forEach((f) => {
          FileUrl(f.getNative(), (err, imgsrc) => {
            f.imgsrc = imgsrc;
          });

          // if (!file || !/image\//.test(file.type)) return; //确保文件是图片
          // if (file.type == 'image/gif') { //gif使用FileReader进行预览,因为mOxie.Image只支持jpg和png
          //   var fr = new mOxie.FileReader();
          //   fr.onload = function () {
          //     file.imgsrc = fr.result;
          //     fr.destroy();
          //     fr = null;
          //   };
          //   fr.readAsDataURL(file.getSource());
          // } else {
          //   var preloader = new mOxie.Image();
          //   preloader.onload = function () {
          //     preloader.downsize(180, 120); //先压缩一下要预览的图片
          //     var imgsrc = preloader.type == 'image/jpeg' ? preloader.getAsDataURL('image/jpeg', 80) : preloader.getAsDataURL(); //得到图片src,实质为一个base64编码的数据
          //     file.imgsrc = imgsrc;
          //     preloader.destroy();
          //     preloader = null;
          //   };
          //   preloader.load(file.getSource());
          // }
        });
      }
    }
  }
</script>

<style scoped>

</style>
