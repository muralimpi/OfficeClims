package com.serole.claims.model.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
@PropertySources({
    @PropertySource("classpath:application.properties"),
    @PropertySource("file:${claims.config.file.location}/${claims.config.file.name}.properties")
})
public class ElsecoClaimsConstant {

	@Value("${cims.environment}")
	public String ENVIRONMENT;	
	
	@Value("${cims.entity.claim_detail}")
	public String CLAIM_DETAIL;
	
	@Value("${cims.entity.claim_header}")
	public String CLAIM_HEADER;
	
	@Value("${cims.entity.claim_item}")
	public String CLAIM_ITEMS;
	
	@Value("${cims.entity.claim_reserve}")
	public String CLAIM_RESERVE;
	
	@Value("${cims.entity.claim_notes}")
	public String CLAIM_NOTES;
	
	@Value("${cims.entity.claim_tasks}")
	public String CLAIM_TASKS;
	
	@Value("${cims.entity.claim_file}")
	public String CLAIM_FILES;
	
	@Value("${cims.entity.claim_transaction}")
	public String CLAIM_TRANSACTIONS;
	
	@Value("${cims.entity.claim_risk}")
	public String CLAIM_RISKOBJ;
	
	@Value("${cims.entity.claim_member.info}")
	public String CLAIM_MEMBER_INFO;
	
	@Value("${cims.entity.claim_member.result}")
	public String CLAIM_MEMBER_RESULT;	
	
	@Value("${cims.entity.claim_member.riskcode}")
	public String CLAIM_MEMBER_RISKCODE;
	
	@Value("${cims.entity.claim_check.list}")
	public String CLAIM_CHECK_LIST;
	
	@Value("${cims.entity.hybris.payhistory}")
	public String HYBRIS_PAYHISTORY;
	
	@Value("${cims.entity.claim_internal.reference}")
	public String CLAIM_INTERNAL_REF;
	
	@Value("${cims.entity.claim_party}")
	public String CLAIM_PARTY;
	
	@Value("${cims.entity.claim_policy_payee}")
	public String CLAIM_POLICY_PAYEE;
	
	@Value("${cims.audit.applicationHandle}")
	public String APPLICATIONHANDLE;
	
	@Value("${cims.audit.moduleHandle}")
	public String MODULEHANDLE;
	
	@Value("${cims.audit.operatorType.Update}")
	public String OPERATORTYPE_UPDATE;
	
	@Value("${cims.audit.operatorType.Insert}")
	public String OPERATORTYPE_INSERT;
	
	@Value("${cims.audit.operatorType.Delete}")
	public String OPERATORTYPE_DELETE;
	
	@Value("${cims.handler.claims}")
	public String HANDLER_CLAIMS;
	
	@Value("${cims.handler.audit}")
	public String HANDLER_AUDIT;
	
	@Value("${cims.handler.navigation}")
	public String HANDLER_NAVIGATION;
	
	@Value("${cims.handler.user}")
	public String HANDLER_USER;
	
	@Value("${cims.handler.deal}")
	public String HANDLER_DEAL;
	
	@Value("${cims.handler.incident}")
	public String HANDLER_INCIDENT;	
	
	/*
	@Value("${cims.section.hull}")
	public String SECTION_HULL;
	
	@Value("${cims.section.liability}")
	public String SECTION_LIABILITY;
	
	@Value("${cims.section.spares}")
	public String SECTION_SPARES;
	
	@Value("${cims.section.tlo}")
	public String SECTION_TLO;
	
	@Value("${cims.section.av52}")
	public String SECTION_AV52;
	
	@Value("${cims.section.other}")
	public String SECTION_OTHER;
	*/
	@Value("${cims.status.approve}")
	public String STATUS_APPROVED;
	
	@Value("${cims.status.reject}")
	public String STATUS_REJECT;
	
	@Value("${cims.status.pending}")
	public String STATUS_PENDING;
	
	@Value("${cims.status.partial.approve}")
	public String STATUS_PARTIAL_APPROVE;
			
	@Value("${cims.hana.datasource.schema}")
	public static String DATABASE_SCHEMA;
			
	@Value("${cims.hana.datasource.package}")
	public static String DATABASE_PACKAGE;
	
	@Value("${cims.entity.policy_transaction}")
	public String EXTREF_TRANSACTIONS;
	
	@Value("${cims.entity.market_transaction}")
	public String UCR_TRANSACTIONS;
	
	@Value("${cims.entity.policy_notes}")
	public String EXTREF_NOTES;
	
	@Value("${cims.entity.ucr_notes}")
	public String UCR_NOTES;
	
	@Value("${cims.to.nyms.uri.generate.attachment}")
	public String NYMS_EMAIL_ATTCH_SERVICE_URI;
	
	@Value("${cims.to.nyms.uri.release.payment.notify}")
	public String NYMS_RELEASE_PAYMNT_SERVICE_URI;
	
	@Value("${cims.to.nyms.uri.collect.fund.notify}")
	public String NYMS_COLLECT_FUND_SERVICE_URI;
	
	//@Value("${cims.member.result.email}")
	//public String MEMBER_RESULT_EMAIL;
	
	@Value("${cims.deployment.server.ip}")
	public String CIMS_APPLICATION_DEPLOYED_IP;
	
	@Value("${server.port}")
	public String CIMS_APPLICATION_DEPLOYED_PORT;
	
	@Value("${nyms.deployment.server.ip}")
	public String NYMS_APPLICATION_DEPLOYED_IP;
	
	@Value("${nyms.deployment.running.port}")
	public String NYMS_APPLICATION_DEPLOYED_PORT;
		
	@Value("${server.contextPath}")
	public String APPLICATION_SERVICES_CONTEXTPATH;
	
	@Value("${cims.notification.workflow.service}")
	public String CIMS_STATUS_CHANGE_SERVICE;
	
	@Value("${cims.notification.workflow.service.operationHandle}")
	public String PLACEHOLDER_OPERATION_HANDLE;	
	
	@Value("${cims.notification.workflow.service.userBpId}")
	public String PLACEHOLDER_USERBPID;
	
	@Value("${cims.notification.workflow.service.headerId}")
	public String PLACEHOLDER_HEADERID;
	
	@Value("${cims.notification.workflow.service.detailId}")
	public String PLACEHOLDER_DETAILID;
	
	@Value("${cims.notification.workflow.service.statusHandle}")
	public String PLACEHOLDER_STATUSHANDLE;
	
	//Populating claims check list
	@Value("${cims.checklist.header.level.grp}")
	public String CHECKLIST_HEADER_GRP;
	
	@Value("${cims.checklist.header.level.desc.list}")
	public String CHECKLIST_HEADER_DESC_LIST;
		
	@Value("${cims.checklist.detail.level.grp}")
	public String CHECKLIST_DETAIL_GRP;
	
	@Value("${cims.checklist.detail.level.desc.list}")
	public String CHECKLIST_DETAIL_DESC_LIST;
	
	@Value("${cims.checklist.detail.level.grp}")
	public String CHECKLIST_ITEM_GRP;
	
	@Value("${cims.checklist.detail.level.desc.list}")
	public String CHECKLIST_ITEM_DESC_LIST;
	
	@Value("${cims.checklist.detail.level.grp}")
	public String CHECKLIST_FILE_GRP;
	
	@Value("${cims.checklist.detail.level.desc.list}")
	public String CHECKLIST_FILE_DESC_LIST;
	
	/**    
	 * Populating Audit Trail information for displaying on UI   
	**/
	@Value("${cims.audit.trail.tab.handler.ucr.overview}")
	public String TAB_HANDLER_UCR_OVERVIEW;
	
	@Value("${cims.audit.trail.tab.handler.ucr.overview.tables.list}")
	public String TAB_HANDLER_UCR_OVERVIEW_TABLES;
	
	@Value("${cims.audit.trail.tab.handler.ucr.umr}")
	public String TAB_HANDLER_UCR_UMR;
	
	@Value("${cims.audit.trail.tab.handler.ucr.umr.tables.list}")
	public String TAB_HANDLER_UCR_UMR_TABLES;
	
	@Value("${cims.audit.trail.tab.handler.ucr.incident}")
	public String TAB_HANDLER_UCR_INCIDENT;
	
	@Value("${cims.audit.trail.tab.handler.ucr.incident.tables.list}")
	public String TAB_HANDLER_UCR_INCIDENT_TABLES;
	
	@Value("${cims.audit.trail.tab.handler.ucr.market}")
	public String TAB_HANDLER_UCR_MKT_TRANS;
	
	@Value("${cims.audit.trail.tab.handler.ucr.market.tables.list}")
	public String TAB_HANDLER_UCR_MKT_TRANS_TABLES;
	
	@Value("${cims.audit.trail.tab.handler.ucr.notes}")
	public String TAB_HANDLER_UCR_NOTES;
	
	@Value("${cims.audit.trail.tab.handler.ucr.notes.tables.list}")
	public String TAB_HANDLER_UCR_NOTES_TABLES;
	
	@Value("${cims.audit.trail.tab.handler.ucr.chklist}")
	public String TAB_HANDLER_UCR_CHK_LIST;
	
	@Value("${cims.audit.trail.tab.handler.ucr.chklist.tables.list}")
	public String TAB_HANDLER_UCR_CHK_LIST_TABLES;
	
	@Value("${cims.audit.trail.tab.handler.extref.overview}")
	public String TAB_HANDLER_EXT_REF_OVERVIEW;
	
	@Value("${cims.audit.trail.tab.handler.extref.overview.tables.list}")
	public String TAB_HANDLER_EXT_REF_OVERVIEW_TABLES;
	
	@Value("${cims.audit.trail.tab.handler.ext.policytrans}")
	public String TAB_HANDLER_EXT_POLICY_TRANS;
	
	@Value("${cims.audit.trail.tab.handler.ext.policytrans.tables.list}")
	public String TAB_HANDLER_EXT_POLICY_TRANS_TABLES;
	
	@Value("${cims.audit.trail.tab.handler.ext.notes}")
	public String TAB_HANDLER_EXT_NOTES;
	
	@Value("${cims.audit.trail.tab.handler.ext.notes.tables.list}")
	public String TAB_HANDLER_EXT_NOTES_TABLES;
	
	@Value("${cims.audit.trail.tab.handler.ext.chklist}")
	public String TAB_HANDLER_EXT_CHK_LIST;
	
	@Value("${cims.audit.trail.tab.handler.ext.chklist.tables.list}")
	public String TAB_HANDLER_EXT_CHK_LIST_TABLES;
	
	@Value("${cims.audit.trail.tab.handler.claims.ucr.trans}")
	public String TAB_HANDLER_UCR_TRANSACTIONS;
	
	@Value("${cims.audit.trail.tab.handler.claims.ucr.trans.tables.list}")
	public String TAB_HANDLER_UCR_TRANSACTIONS_TABLES;
	
	@Value("${cims.audit.trail.tab.handler.claims.ext.trans}")
	public String TAB_HANDLER_EXTREF_TRANSACTIONS;
	
	@Value("${cims.audit.trail.tab.handler.claims.ext.trans.tables.list}")
	public String TAB_HANDLER_EXTREF_TRANSACTIONS_TABLES;
	
	@Value("${cims.audit.trail.tab.handler.claims.member.info}")
	public String TAB_HANDLER_CLAIM_MEMBER_INFO;
	
	@Value("${cims.audit.trail.tab.handler.claims.member.info.tables.list}")
	public String TAB_HANDLER_CLAIM_MEMBER_INFO_TABLES;
	
	@Value("${cims.audit.trail.tab.handler.claims.internal.ref}")
	public String TAB_HANDLER_CLAIM_INTERNAL_REF;
	
	@Value("${cims.audit.trail.tab.handler.claims.internal.ref.tables.list}")
	public String TAB_HANDLER_CLAIM_INTERNAL_REF_TABLES;
		
	//Transaction Types
	@Value("${cims.transaction.type.initial.advice}")
	public String TX_TYP_INITIAL_ADVICE;
	
	@Value("${cims.transaction.type.additional.information}")
	public String TX_TYP_ADDITIONAL_INFORMATION;
	
	@Value("${cims.transaction.type.payment.request}")
	public String TX_TYP_PAYMNT_REQUEST;
	
	@Value("${cims.transaction.type.final.payment}")
	public String TX_TYP_FINAL_PAYMENT;
	
	@Value("${cims.transaction.type.update.reserve}")
	public String TX_TYP_UPDATE_RESERVE;
	
	@Value("${cims.transaction.type.sobgration.tex}")
	public String TX_TYP_SOBGRATION_TEX;
	
	@Value("${cims.transaction.type.sobgration}")
	public String TX_TYP_SOBGRATION;
	
	@Value("${cims.transaction.type.salvage}")
	public String TX_TYP_SALVAGE;
	
	//Set the common Timezone across the application
	@Value("${app.set.common.timezone}")
	public String APPLICATION_COMMON_TIMEZONE;	
	
	@Value("${claims.log.file.location}")
	public String LOG_FOLDER;
	
	@Value("${claims.log.file.name}")
	public String LOG_FILENAME;
}
