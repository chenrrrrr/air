<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="./../static/layui/css/layui.css" />
    <link rel="stylesheet/less" type="text/css" href="./../static/less/login.less" />
    <title>登录</title>
  </head>
  <body>
    <div class="layui-container">
      <div class="fly-panel">
        <div class="layui-tab layui-tab-brief">
          <ul class="layui-tab-title">
            <li class="layui-this">登入</li>
            <li>注册</li>
          </ul>
          <div class="layui-form layui-tab-content">
            <div class="layui-tab-item layui-show">
              <div class="layui-form">
                <div class="layui-form-item">
                  <label class="layui-form-label">用户名</label>
                  <div class="layui-input-inline">
                    <input type="text" id="username" name="username" required="" lay-verify="required" autocomplete="off" class="layui-input">
                  </div>
                </div>
              </div>
            </div>
            <div class="layui-tab-item">
              <div class="layui-form">
                <div class="layui-form-item">
                  <label class="layui-form-label">密码</label>
                  <div class="layui-input-inline">
                    <input type="text" id="password" name="password" required="" lay-verify="required" autocomplete="off" class="layui-input">
                  </div>
                </div>
              </div>
            </div>
            <div class="layui-form-item">
              <button class="layui-btn" lay-filter="*" lay-submit="">立即登录</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
  <script src="./../static/layui/layui.all.js"></script>
  <script src="./../static//js//less.js"></script>
  <script>
    layui.use(['jquery', 'layer', 'form'], function() {
      var layer = layui.layer,
        $ = layui.$,
        form = layui.form;

      layer.msg('Hello World');
    });
  </script>
</html>
