<?xml version="1.0" encoding="windows-1252"?>
<!-- 
    Document   : AdditionQuiz
    Created on : Feb 8, 2010, 9:49:20 PM
    Author     : Daniel
-->
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=windows-1252" pageEncoding="windows-1252"/>
    <f:view>
        <ui:page id="page1">
            <ui:html id="html1">
                <ui:head id="head1">
                    <ui:link id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body id="body1" style="-rave-layout: grid">
                    <ui:form id="form1">
                        <ui:staticText binding="#{AdditionQuiz.staticText1}" id="staticText1"
                            style="height: 24px; left: 48px; top: 24px; position: absolute; width: 334px" text="Addition Quiz status: 0/0"/>
                        <h:panelGrid id="gridPanel3" style="height: 72px; left: 48px; top: 48px; position: absolute" width="336">
                            <h:panelGrid columns="3" id="gridPanel1" style="height: 24px" width="335">
                                <ui:staticText binding="#{AdditionQuiz.staticText2}" id="staticText2"/>
                                <ui:textField binding="#{AdditionQuiz.textField1}" id="textField1" style="height: 24px; width: 48px"/>
                                <ui:button action="#{AdditionQuiz.button1_action}" id="button1" style="height: 24px; width: 72px" text="Submit"/>
                            </h:panelGrid>
                            <h:panelGrid id="gridPanel2" style="height: 24px" width="263">
                                <ui:staticText binding="#{AdditionQuiz.staticText3}" id="staticText3" style="height: 24px; width: 120px"/>
                            </h:panelGrid>
                        </h:panelGrid>
                        <ui:staticText id="staticText4" style="position: absolute; left: 48px; top: 144px; width: 336px; height: 24px" text="Developed by (put Your Name here)"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
