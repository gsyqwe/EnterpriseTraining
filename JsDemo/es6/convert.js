const PAGE_SIZE = 10
const SYS_NAME = '教学辅助系统'

function demo(){
    return 'hello'
}
//导出变量或方法
export {
    PAGE_SIZE as ps,
    SYS_NAME,
    demo
}