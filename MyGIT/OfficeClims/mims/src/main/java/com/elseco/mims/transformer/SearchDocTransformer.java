package com.elseco.mims.transformer;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.elseco.mims.client.Files;
import com.elseco.mims.client.Item;
import com.elseco.mims.client.MFSearchDocResponse;
import com.elseco.mims.client.ObjVer;
import com.elseco.mims.model.DocInfo;

/**
 * 
 * @author vadivel
 *
 */
@Component
public class SearchDocTransformer {
	private static final Logger LOG = LoggerFactory.getLogger(SearchDocTransformer.class);

	public List<DocInfo> transform(final MFSearchDocResponse mfSearchDocResponse) {
		LOG.info("Transforming the response");
		final List<DocInfo> ui5SearchDocResponses = new ArrayList<>();
		DocInfo searchRequest = null;
		for (final Item item : mfSearchDocResponse.getItems()) {
			final ObjVer objVer = item.getObjVer();
			final Files file = item.getFiles()[0];

			searchRequest = new DocInfo();

			searchRequest.setObjectType(objVer.getType());
			searchRequest.setObjectVersion(objVer.getVersion());
			searchRequest.setObjectId(objVer.getID());
			searchRequest.setFileId(file.getID());
			searchRequest.setFileName(file.getEscapedName());
			searchRequest.setFileExtention(file.getExtension());
			ui5SearchDocResponses.add(searchRequest);
		}

		return ui5SearchDocResponses;
	}

	public DocInfo transform(final Item item) {
		LOG.info("Transforming the response");
		DocInfo docInfo = null;

		final ObjVer objVer = item.getObjVer();
		final Files file = item.getFiles()[0];

		docInfo = new DocInfo();

		docInfo.setObjectType(objVer.getType());
		docInfo.setObjectVersion(objVer.getVersion());
		docInfo.setObjectId(objVer.getID());
		docInfo.setFileId(file.getID());
		docInfo.setFileName(file.getEscapedName());
		docInfo.setFileExtention(file.getExtension());
		
		return docInfo;
	}
}
