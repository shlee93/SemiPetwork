<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 다음 주소 검색 API -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
/* 주소 검색 버튼 클릭 시 실행 */
function fn_getAddressInfo(){
	var width = 500; //팝업의 너비
	var height = 600; //팝업의 높이
	new daum.Postcode({
           oncomplete: function(data) {
    	    if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
            } else {
            	var expJibunAddr = data.jibunAddress;
            }
           document.getElementById("sharingPostAddress").value = expJibunAddr;
           // 커서를 상세주소 필드로 이동한다.
           document.getElementById("sharingPostAddress").focus();
           },
           shorthand : false //'시','도' 부분을 축약 표시
        	}).open({
  				popupName: 'postcodePopup',
				left: (window.screen.width / 2) - (width / 2),
			    top: (window.screen.height / 2) - (height / 2)
      		});
}
</script>
<style>
#sharing-post-detail-write > div.row.form-inline{
		margin-top:0.5em;
	}
	#postImgAddress0{
		margin-top:0.5em;
	}
	#postImgAddress1{
		margin-top:0.5em;
	}
	#postImgAddress2{
		margin-top:0.5em;
	}
</style>
<%@ include file="/views/common/header.jsp"%>

<section>

	<div class='container-fluid'>
		<div class='row' id="contents">
			<div class='col-md-2 admin-post-list-nav' id='nav'></div>

			<div class='col-md-8' id='section'>

				<form id="sharing-post-detail-write" name="sharingPostWriteFrm" action="<%=request.getContextPath() %>/board/sharingBoardInsertEnd?loginMember=<%=loginMember.getId() %>" method="POST" enctype="multipart/form-data">
				<!-- 레이스 나누는 라디오 버튼 부분 -->
				<div class="row" id="post-radio">
                      <div class="col-md-2">
                          <span class="post-detail-write-title-radio" id="post-detail-write-title-radio">글머리</span>
                      </div>
                         <div class="col-md-3">
                            <label class="sharing-text-head-select"><span>강아지 </span><input type="radio" name="RaceCode" class="sharing-text-head-radio ml-2 mt-1" value="D" checked></label>
                         </div>
                         <div class="col-md-3">
                            <label class="sharing-text-head-select"><span>고양이 </span><input type="radio" name="RaceCode" class="sharing-text-head-radio ml-2 mt-1" value="C"></label>
                         </div>
                         <div class="col-md-3">
                            <label class="sharing-text-head-select"><span>기타 </span><input type="radio" name="RaceCode" class="sharing-text-head-radio ml-2 mt-1" value="E"></label>
                         </div>
                         <div class="col-md-1"></div>
                   </div>

				<!-- 상품 선택 글머리 -->
				<div class="row">
					<div class="col-md-2 mt-3">
						<span id="text-head">상품</span>
					</div>
					<div class="col-md-10">
						<div class="post-detail-write-head">
							<label class="post-detail-write-head-select">식품	<input class="ml-2 mt-1" type="radio" name="product" value="P1" required></label> 
							<label class="post-detail-write-head-select">위생<input class="ml-2 mt-1" type="radio" name="product" value="P2" required></label> 
							<label class="post-detail-write-head-select">장난감<input class="ml-2 mt-1" type="radio" name="product" value="P3" required></label> 
							<label class="post-detail-write-head-select">하우스<input class="ml-2 mt-1" type="radio" name="product" value="P4" required></label>
							<label class="post-detail-write-head-select">의류<input class="ml-2 mt-1" type="radio" name="product" value="P5" required></label>
						</div>
					</div>
				</div>

				<!-- 작성 부분 -->

				<div class="row form-inline">
					<div class="col-md-2">
						<span id="post-detail-write-title">제목</span>
					</div>
					<div class="col-md-10"> 
						<input class="form-control" type="text" id="sharingPostTitle" name="sharingPostTitle" required>
					</div>
				</div>
				<div class="row form-inline">
					<div class="col-md-2">
						<span id="post-detail-write-writer">작성자</span>
					</div>
					<div class="col-md-10"> 
						<input class="form-control" type="text" id="sharingPostWriter" name="sharingPostWriter" readonly="readonly" value="<%=loginMember.getId()%>">
					</div>
				</div>
				<div class="row form-inline">
					<div class="col-md-2">
						<span id="post-detail-write-address">거래주소</span>
					</div>
					<div class="col-md-10"> 
						<input class="form-control" type="text" id="sharingPostAddress" name="sharingPostAddress" required readonly onclick="fn_getAddressInfo();">
					</div>
				</div>
				<div class="row form-inline">
					<div class="col-md-3">
						<span id="post-detail-write-YN">거래여부</span>
					</div>
					<div class="col-md-3"> 
						<input class="ml-2 mt-1" type="radio" id="sharingPostYN" name="sharingPostYN" value="Y" disabled> Y
					</div>
					<div class="col-md-3">
						<input class="ml-2 mt-1" type="radio" id="sharingPostYN" name="sharingPostYN" value="N" checked> N
					</div>
				</div>
				<div class="row form-inline">
					<div class="col-md-2">
						<span id="post-detail-write-writer">내용</span>
					</div>
					<div class="col-md-10">
						<textarea class="form-control" rows="5" cols="95" name="postContent" id="postContent" placeholder="상세설명을 입력해주세요" required></textarea>
					</div>
				</div>
				<div class="row form-inline" id="post-detail-write-file">
					<div class="col-md-2">
						<span id="post-detail-write-add-img-text">사진첨부</span>
					</div>
					<div class="col-md-10" id="post-detail-write-add-img">
						<input class="form-control" type="file" id="postImgAddress0" name="postImgAddress1" required>
					</div>
					<div class="col-md-2">
						<span id="post-detail-write-add-img-text2">사진첨부</span>
					</div>
					<div class="col-md-10" id="post-detail-write-add-img">
						<input class="form-control" type="file" id="postImgAddress1" name="postImgAddress2">
					</div>
					<div class="col-md-2">
						<span id="post-detail-write-add-img-text3">사진첨부</span>
					</div>
					<div class="col-md-10" id="post-detail-write-add-img">
						<input class="form-control" type="file" id="postImgAddress2" name="postImgAddress3">
					</div>
					
				</div>
				<script>

				$(function(){
					$('#postImgAddress0').on("change",function(){
						$('#post-detail-write-add-img-text2').css('display','inline');
						$('#postImgAddress1').css('display','inline');
					});
				});
				$(function(){
					$('#postImgAddress1').on("change",function(){
						$('#post-detail-write-add-img-text3').css('display','inline');
						$('#postImgAddress2').css('display','inline');
					});
				});
			    </script>
				<div class="row">
					<div class="col-md-12 mb-2" id="sharing-post-detail-write-btn">
						<input type="reset" value="취소" class="btn btn-primary" id="user-btn-cancel" name="btn-cancel"> 
						<input type="submit" value="등록" class="btn btn-primary" id="btn-ok" name="btn-ok">
					</div>
				</div>
				</form>
			</div>
			<div class='col-md-2' id='aside'></div>

		</div>
	</div>

</section>

<%@ include file="/views/common/footer.jsp"%>