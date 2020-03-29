$(function(){
  $('.layui-nav-child').on({
	click:function(){
		let thisText=$(this).text().trim();
      if(thisText=="栏目信息查询"){
        $('.layui-body').load('http://localhost:8080/background/category/findAll');
        
      }
       if(thisText=="文章信息查询"){
        $('.layui-body').load('http://localhost:8080/background/article/findAll');
      }
       if(thisText=="章节信息查询"){
        $('.layui-body').load('http://localhost:8080/background/chapter/findAll');
        
      }
      if(thisText=="读者信息查询"){
        $('.layui-body').load('./pages/feedback.html');
        
      }
       if(thisText=="角色管理"){
        $('.layui-body').load('./pages/role.html');
        
      }
       if(thisText=="用户管理"){
        $('.layui-body').load('./pages/user.html');
       
      }
    }
  },'dd');
});




