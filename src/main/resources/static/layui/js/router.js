$(function(){
  $('.layui-nav-child').on({click:function(){
      if($(this).text()=="栏目信息查询"){
        $('.layui-body').load('background/findAllCategory');
       
      }
       if($(this).text()=="文章信息查询"){
        $('.layui-body').load('./pages/sales.html');
        
      }
       if($(this).text()=="章节信息查询"){
        $('.layui-body').load('customer/findAllCustomerByPage/1');
        
      }
      if($(this).text()=="读者信息查询"){
        $('.layui-body').load('./pages/feedback.html');
        
      }
       if($(this).text()=="角色管理"){
        $('.layui-body').load('./pages/role.html');
        
      }
       if($(this).text()=="用户管理"){
        $('.layui-body').load('./pages/user.html');
       
      }
      
    }
  },'dd');
});




