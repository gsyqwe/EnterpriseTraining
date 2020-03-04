window.onload = function(){
    //取全选
    var checkAll = document.getElementsByClassName("check-all")
    //取单选择
    var checkOne = document.getElementsByClassName("check-one")
    //取总价
    var priceTotal = document.getElementById("priceTotal")
    //取商品数量
    var selectedTotal = document.getElementById("selectedTotal")
    //取所有的删除span
    var deleteSpan =  document.getElementsByClassName("delete")

    //取table
    var tab = document.getElementById("cartTable")
    //取tbody
    var tbody = tab.children[1];
    //取tbody下所有的行
    var rows = tbody.children

    //给单选添加点击事件
    for(var i=0;i<checkOne.length;i++){
        checkOne[i].onclick = function(){
            getTotal()
        }
    }

    //给所有的删除添加事件
    for(var i=0;i<deleteSpan.length;i++){
        deleteSpan[i].onclick = function(){
            //找到所在行并删除
            this.parentNode.parentNode.remove()
            //重新统计总计
            getTotal()
        }
    }

    //遍历每一行
    for(var i=0;i<rows.length;i++){
        //取数量的td
        var cell = rows[i].cells[3]
        //取-span
        var reduce = cell.getElementsByClassName("reduce")[0]
        //取+span
        var add = cell.getElementsByClassName("add")[0]
        //给-添加单击事件
        reduce.onclick = function(){
            //取当前行
            var row = this.parentNode.parentNode
            //取单价
            var perPrice = parseFloat(row.children[2].innerHTML)
            //数量-1
            this.parentNode.getElementsByClassName("count-input")[0].value =
                parseInt(this.parentNode.getElementsByClassName("count-input")[0].value)-1
            //计算小计
            row.cells[4].innerHTML = perPrice * parseInt(this.parentNode.getElementsByClassName("count-input")[0].value)
            getTotal();
        }
        //给+添加单击事件
        add.onclick = function(){
            //取当前行
            var row = this.parentNode.parentNode
            //取单价
            var perPrice = parseFloat(row.children[2].innerHTML)
            this.parentNode.getElementsByClassName("count-input")[0].value =
                parseInt(this.parentNode.getElementsByClassName("count-input")[0].value)+1
            //计算小计
            row.cells[4].innerHTML = perPrice * parseInt(this.parentNode.getElementsByClassName("count-input")[0].value)
            getTotal();
        }

    }

    //计算总价
    function getTotal(){
        var sum = 0
        var total = 0
        for(var i=0;i<checkOne.length;i++){
            if(checkOne[i].checked){
                //取出小计并累加
                sum += parseFloat(rows[i].cells[4].innerHTML);
                //取数量并累加
                total += parseInt(rows[i].getElementsByClassName("count-input")[0].value)
            }
        }
        priceTotal.innerHTML = sum.toFixed(2)
        selectedTotal.innerHTML= total
    }
}