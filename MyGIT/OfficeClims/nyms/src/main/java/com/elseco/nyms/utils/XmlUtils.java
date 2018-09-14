package com.elseco.nyms.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.serole.core.exception.XmlParserException;

/**
 * 
 * @author vadivel
 *
 */

public class XmlUtils {
	private static final Logger LOG = LoggerFactory.getLogger(JsonUtils.class);
	private static final XPath XPATH = XPathFactory.newInstance().newXPath();
	private static final String XPAHT_REPORTS_REPORT = "reports/report";

	public static List<Object> parseXmlReportContent(final InputStream inputStream) {
		final List<Object> reportContent = new ArrayList<>();
		NodeList reportsNodeList;
		Document document;
		try {
			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
			reportsNodeList = (NodeList) XPATH.evaluate(XPAHT_REPORTS_REPORT, document, XPathConstants.NODESET);
			for (int i = 0; i < reportsNodeList.getLength(); i++) {
				final Node reportNode = reportsNodeList.item(i);
				final Map<String, Object> report = new HashMap<>();
				final NodeList reportNodeList = reportNode.getChildNodes();

				for (int j = 0; j < reportNodeList.getLength(); j++) {
					final Node reportChild = reportNodeList.item(j);
					final short type = reportChild.getNodeType();
					if (reportChild == null || type != 1) {
						continue;
					}
					report.put(reportChild.getNodeName(), reportChild.getTextContent());
				}
				reportContent.add(report);

			}
		} catch (SAXException | IOException | ParserConfigurationException | XPathExpressionException e) {
			LOG.error("Unable to parse xml due to....{}", e);
			throw new XmlParserException("Unable to parse xml");
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					LOG.error("Unable to parse xml due to....{}", e);
					throw new XmlParserException("Unable to parse xml");
				}
			}
		}

		return reportContent;
	}
}
