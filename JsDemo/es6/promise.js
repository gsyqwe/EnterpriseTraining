/** Promise是一个代理对象,它和原先要进行的操作并无关系
 *  它通过引入一个回调,避免更多的回调
 *  Promise有3个状态:
 *  pending [待定]初始状态
 *  fulfilled [实现]操作成功
 *  rejected [被否决]操作失败
 *  Promise状态发生改变,就会触发.then()里的响应函数得理后续步聚,
 *  如果是resolve会调用第一个函数,如果是reject会调用第二个函数
 *  Promise状态一经改变,不会再变
 * Created by Administrator on 2018/5/23.
 */

new Promise((resolve,reject) => {
            //模拟获取服务器数据
            setTimeout(function(){
                //获取成功调用resolve方法，把结果做为参数
                resolve('hello world')
                //获取失败调用reject方法
                reject('error...')
                console.log(val)
            },5000)
    //执行成功
    }).then((val)=>{
       console.log(val)
    //执行失败
    }).catch((err)=>{
        console.log('失败了',err)
})
