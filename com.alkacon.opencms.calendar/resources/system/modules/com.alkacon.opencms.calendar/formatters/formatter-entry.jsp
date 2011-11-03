<%@ page session="false" %>
<%@ taglib prefix="cms" uri="http://www.opencms.org/taglib/cms" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<cms:formatter var="content" val="value">
<div>

<c:set var="vfs" value="${cms:vfs(pageContext)}" />
<c:set var="locale" value="${vfs.requestContext.locale}"/>

<fmt:setLocale value="${locale}" />
<fmt:bundle basename="com.alkacon.opencms.calendar.display">

<%-- Headline --%>  
<h1 class="cal_detail_headline">${value.Title}</h1>

<%-- Dates --%>
<p class="cal_detail_date">
	<span class="cal_detail_label"><fmt:message key="calendar.detail.date" /></span>:
	<c:set var="dateType" value="date"/>
	<c:if test="${value.Showtime == 'true'}">
		<c:set var="dateType" value="both"/>
	</c:if>
	<fmt:formatDate value="${cms:convertDate(value.Date)}" dateStyle="long" timeStyle="short" type="${dateType}" />
	<c:if test="${value.End.exists}">
		<c:set var="start"><fmt:formatDate value="${cms:convertDate(value.Date)}" dateStyle="short" type="date" /></c:set>
		<c:set var="end"><fmt:formatDate value="${cms:convertDate(value.End)}" dateStyle="short" type="date" /></c:set>
		<c:if test="${start == end && value.Showtime == 'true'}">
			<fmt:message key="calendar.detail.date.to" />
			<fmt:formatDate value="${cms:convertDate(value.End)}" timeStyle="short" type="time" />
		</c:if>
		<c:if test="${start != end}">
			<fmt:message key="calendar.detail.date.to" />
			<fmt:formatDate value="${cms:convertDate(value.End)}" dateStyle="long" timeStyle="short" type="${dateType}" />
		</c:if>
	</c:if>
	
</p>

<%-- Location --%>
<c:if test="${!value.Location.isEmptyOrWhitespaceOnly}">
<p class="cal_detail_location">
	<span class="cal_detail_label"><fmt:message key="calendar.detail.location" /></span>: ${value.Location}
</p>
</c:if>

<%-- Text --%>
<div class="cal_detail_text">
	${value.Text}
</div>

<%-- Links --%>
<c:if test="${value.Links.exists}">
	<p class="cal_detail_links"><span class="cal_detail_label"><fmt:message key="calendar.detail.links" /></span>:</p><ul>
	<c:forEach var="link" items="${valueList.Links}">
		<c:if test="${fn:indexOf(link.value.Uri, '/') == 0 && vfs.existsResource[link.value.Uri] || fn:indexOf(link.value.Uri, '/') != 0}">
			<li>
				<c:set var="linktext">${link.value.Uri}</c:set>
				<c:if test="${link.value.Description.exists}">
					<c:set var="linktext">${link.value.Description}</c:set>
				</c:if>
				<a href="<cms:link>${link.value.Uri}</cms:link>">${linktext}</a>
			</li>
		</c:if>
	</c:forEach>
	</ul>
</c:if>

<p>
	<a href="javascript:history.back();"><fmt:message key="calendar.detail.back" /></a>
</p>

</fmt:bundle>

</div>
</cms:formatter> 