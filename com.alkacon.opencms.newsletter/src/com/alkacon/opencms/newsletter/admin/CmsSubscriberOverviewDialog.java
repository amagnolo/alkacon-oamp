/*
 * File   : $Source: /alkacon/cvs/alkacon/com.alkacon.opencms.newsletter/src/com/alkacon/opencms/newsletter/admin/CmsSubscriberOverviewDialog.java,v $
 * Date   : $Date: 2007/10/26 14:53:40 $
 * Version: $Revision: 1.3 $
 *
 * This library is part of OpenCms -
 * the Open Source Content Mananagement System
 *
 * Copyright (c) 2005 Alkacon Software GmbH (http://www.alkacon.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software GmbH, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package com.alkacon.opencms.newsletter.admin;

import org.opencms.jsp.CmsJspActionElement;
import org.opencms.widgets.CmsDisplayWidget;
import org.opencms.workplace.CmsWidgetDialogParameter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

/**
 * The subscriber overview and subscriber info widget dialog.<p>
 * 
 * @author Michael Moossen
 * @author Andreas Zahner
 * 
 * @version $Revision: 1.3 $ 
 * 
 * @since 7.0.3 
 */
public class CmsSubscriberOverviewDialog extends org.opencms.workplace.tools.accounts.CmsUserOverviewDialog {

    /** localized messages Keys prefix. */
    public static final String SB_KEY_PREFIX = "subscriber";

    /**
     * Public constructor with JSP action element.<p>
     * 
     * @param jsp an initialized JSP action element
     */
    public CmsSubscriberOverviewDialog(CmsJspActionElement jsp) {

        super(jsp);

    }

    /**
     * Public constructor with JSP variables.<p>
     * 
     * @param context the JSP page context
     * @param req the JSP request
     * @param res the JSP response
     */
    public CmsSubscriberOverviewDialog(PageContext context, HttpServletRequest req, HttpServletResponse res) {

        this(new CmsJspActionElement(context, req, res));
    }

    /**
     * @see org.opencms.workplace.tools.accounts.CmsUserOverviewDialog#createDialogHtml(java.lang.String)
     */
    protected String createDialogHtml(String dialog) {

        StringBuffer result = new StringBuffer(1024);

        result.append(createWidgetTableStart());
        // show error header once if there were validation errors
        result.append(createWidgetErrorHeader());

        if (dialog.equals(PAGES[0])) {
            // create the widgets for the first dialog page
            result.append(dialogBlockStart(key(org.opencms.workplace.tools.accounts.Messages.GUI_USER_EDITOR_LABEL_IDENTIFICATION_BLOCK_0)));
            result.append(createWidgetTableStart());
            result.append(createDialogRowsHtml(0, 3));
            result.append(createWidgetTableEnd());
            result.append(dialogBlockEnd());
        }

        result.append(createWidgetTableEnd());
        return result.toString();
    }

    /**
     * @see org.opencms.workplace.tools.accounts.CmsUserOverviewDialog#defineWidgets()
     */
    protected void defineWidgets() {

        // initialize the user object to use for the dialog
        initUserObject();

        setKeyPrefix(SB_KEY_PREFIX);

        // widgets to display
        addWidget(new CmsWidgetDialogParameter(m_user, "email", PAGES[0], new CmsDisplayWidget()));
        addWidget(new CmsWidgetDialogParameter(m_user, "lastname", PAGES[0], new CmsDisplayWidget()));
        addWidget(new CmsWidgetDialogParameter(m_user, "firstname", PAGES[0], new CmsDisplayWidget()));
        addWidget(new CmsWidgetDialogParameter(m_user, "enabled", PAGES[0], new CmsDisplayWidget()));
    }

    /**
     * @see org.opencms.workplace.CmsWorkplace#initMessages()
     */
    protected void initMessages() {

        // add specific dialog resource bundle
        addMessages(Messages.get().getBundleName());
        // add default resource bundles
        super.initMessages();
    }
}
