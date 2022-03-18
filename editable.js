//表头数据
  var dataTitle = ['学 号', '姓 名', '语 文', '数 学', '英 语', '品 德']
  //模拟json表中数据
  var dataList = [
      { id: 1, name: '小王', chineseGrade: 80, mathGrade: 90, englishGrade: 99, moralityGrade: 200 },
      { id: 2, name: '小明', chineseGrade: 79, mathGrade: 88, englishGrade: 75, moralityGrade: 220 },
      { id: 3, name: '小超', chineseGrade: 50, mathGrade: 67, englishGrade: 56, moralityGrade: 230 },
      { id: 4, name: '小李', chineseGrade: 60, mathGrade: 88, englishGrade: 66, moralityGrade: 240 },
  ]
  //配置操作列对象
  /*
  （所有列都是从0开始）
  ediColumns：[col1,col2,col3...] 表示你要修改的列是那几列
  ediRule：[min,max] 必须是数字，表示你所要修改的列的验证规则,表示在min~max的区间之内
  ediSpecialRule：{列数1:[min,max],列数2:[min.max]..}设定特殊的列不同的验证规则
  isTotal：Boolean 表示是否需要总和功能
  totalEach：[col1,col2,col3]需要计算总分的列数
  isDelete：Boolean 表示是否需要删除功能
  */
  var operateColumns = { ediColumns: [2, 3, 4], ediRule: [0, 100], ediSpecialRule: { 5: [0, 250] }, isTotal: false, totalEach: [2, 3, 4], isDelete: false };
  //生成列表事件
  function establishList(operateColumns) {
      //在删除一行数据后如不清空则在调用上一次的数据就还在
      document.getElementsByClassName("edtable")[0].innerHTML = '';
      //表头模板拼接和创建
      var titleTempalte = `<tr class="list-title">`
      for (let i in dataTitle) {
          titleTempalte += `<th>${dataTitle[i]}</th>`
      }
      //判断是否有总和功能，增添表头总和字样
      if (operateColumns.isTotal) {
          titleTempalte += `<th>总 和</th>`
      }

      //判断是否有删除功能，增添表头删除字样
      if (operateColumns.isDelete) {
          titleTempalte += `<th>删 除</th>`
      }
      titleTempalte += `</tr>`
      document.getElementsByClassName("edtable")[0].insertAdjacentHTML('afterBegin', titleTempalte);

      //表内容模板生成
      //遍历列表数据
      for (one of dataList) {
          //获取所有key值
          let dataItem = Object.keys(one);
          //拼接的开头
          var listTempalte = `<tr class="list-items">`
          //表体模板拼接
          //遍历key值
          for (let key of dataItem) {
              listTempalte += `<td>${one[key]}</td>`
          }

          //判断是否需要增加总分列
          if (operateColumns.isTotal) {
              listTempalte += `<td class="total"></td>`
          }

          //判断是否有删除功能
          if (operateColumns.isDelete) {
              listTempalte += `<td><button>×</button></td>`
          }
          listTempalte += `</tr>`
          document.getElementsByClassName('edtable')[0].insertAdjacentHTML('beforeEnd', listTempalte);
      }
      totalScore(operateColumns);
  }

  //计算总分事件(和绑定事件)
  function totalScore(operateColumns) {
      //调用生成列表事件
      let itemsNodes = document.getElementsByClassName('list-items');
      //遍历每一个tr
      for (let i of itemsNodes) {
          //计算总分
          let totalGrade = 0;
          let tdnodes = i.getElementsByTagName('td');
          //遍历所需要编辑的每一列
          for (let j of operateColumns.ediColumns) {
              //添加编辑点击事件
              tdnodes[j].onclick = ediGrade;
          }
          //判断是否需要总分列
          if (operateColumns.isTotal) {
              for (let k of operateColumns.totalEach) {
                  let grade = parseInt(tdnodes[k].innerHTML);
                  if (isNaN(grade)) {
                      grade = 0;
                  }
                  totalGrade += grade;
              }
              //计算总和并赋值
              i.getElementsByClassName('total')[0].innerHTML = totalGrade;
          }
          //判断是否需要删除列
          if (operateColumns.isDelete) {
              tdnodes[tdnodes.length - 1].getElementsByTagName('button')[0].onclick = deleteRow;
          }
      }
  }

  //点击编辑文本框事件
  function ediGrade(event) {
      //创建新节点并且把输入的数字赋值给所点击的单元格
      let grade = event.target.innerHTML;
      let inputcount = document.getElementsByClassName('active-input')
      if (inputcount.length == 0) {
          var input = document.createElement("input");
          event.target.innerHTML = '';
          event.target.appendChild(input);
          input.setAttribute("class", "active-input");
          input.value = grade;
          input.focus();
          //点击其他地方进行数据保存并且调用totalScore函数让总分重新进行计算
          input.onblur = function () {
              let min, max;
              //首先给常规的验证规则
              min = operateColumns.ediRule[0];
              max = operateColumns.ediRule[1];
              //如果有特殊的验证规则
              if (Object.keys(operateColumns.ediSpecialRule).length != 0) {
                  //遍历特殊验证规则
                  for (i of Object.keys(operateColumns.ediSpecialRule)) {
                      //找出特殊验证规则的对应列数
                      if (event.target.cellIndex == parseInt(i) || i == undefined) {
                          min = operateColumns.ediSpecialRule[i][0];
                          max = operateColumns.ediSpecialRule[i][1];
                          break;
                      }
                  }
              }
              //给对应的验证规则修改对应的提示文字
              let warninfo = '输入有误，请输入' + min + '~' + max + '以内的数字';
              document.getElementsByClassName('warn')[0].innerHTML = warninfo;
              if (isEstimate(input.value, min, max)) {
                  //获取更改数据的id号
                  let ediId = event.target.parentNode.children[0].innerHTML;
                  //获取更改数据在td一行中的第几列（从0开始）
                  let edicell = event.target.cellIndex;
                  //遍历List数据
                  for (let i in dataList) {
                      //找到id值对应的那一条数据
                      if (dataList[i].id == ediId) {
                          //获取要修改数据中的所有keys值数组
                          let dataKeys = Object.keys(dataList[i]);
                          //根据keys数组的索引对对象数据进行修改
                          dataList[i][dataKeys[edicell]] = parseInt(input.value);
                      }
                  }
                  // console.log(dataList);
                  event.target.innerHTML = input.value;
                  // establishList(operateColumns);
                  totalScore(operateColumns);
              } else {
                  document.getElementsByClassName('warn')[0].style.opacity = 1;
                  setTimeout(function () {
                      document.getElementsByClassName('warn')[0].style.opacity = 0;
                  }, 1500);
                  input.select();
              }


          }
      }
  }

  //删除行事件
  function deleteRow(event) {
      //对删除行的id进行获取
      let deletId = event.target.parentNode.parentNode.children[0].innerHTML;
      //遍历数据对象
      for (let i in dataList) {
          //找到删除行id值对应的那一条数据
          if (dataList[i].id == deletId) {
              //对数据列表进行删除
              dataList.splice(i, 1);
          }
      }
      establishList(operateColumns);
  }

  //设置修改验证规则事件  
  function isEstimate(value, min, max) {
      if (min <= parseInt(value) && parseInt(value) <= max) {
          return true;
      } else {
          return false;
      }
  }
  //调用创建函数运行
  establishList(operateColumns);