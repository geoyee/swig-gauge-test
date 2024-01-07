# Node.js调用dll

1. 使用SWIG的`-node`导出后，将生成的`warp.cxx`以及相关的`*.h`和`*.cpp`文件拷贝到一起
2. 安装`node-gyp`：

```shell
npm install node-gyp
```

3. 然后编写`binding.gyp`文件，类似于JSON格式，大致内容如下：

```json
{
  "targets": [
    {
      "target_name": "example",
      "sources": [ "example.cxx", "example_wrap.cxx" ]
    }
  ]
}
```

4. 配置并进行生成，生成后的文件在`./build/Release`：

```shell
node-gyp configure
node-gyp build
```

5. 按下列方式进行加载和使用：

```javascript
var example = require("./build/Release/example");

example.function(...)
```

