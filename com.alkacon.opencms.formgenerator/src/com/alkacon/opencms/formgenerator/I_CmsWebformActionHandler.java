/*
 * File   : $Source: /alkacon/cvs/alkacon/com.alkacon.opencms.formgenerator/src/com/alkacon/opencms/formgenerator/I_CmsWebformActionHandler.java,v $
 * Date   : $Date: 2010/05/21 13:49:15 $
 * Version: $Revision: 1.2 $
 *
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (C) 2010 Alkacon Software (http://www.alkacon.com)
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
 * For further information about Alkacon Software, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package com.alkacon.opencms.formgenerator;

import org.opencms.file.CmsObject;

/**
 * Interface to execute any action after the webform was sent. <p>
 * 
 * @author Mario Jaeger
 * 
 * @version $Revision: 1.2 $ 
 * 
 * @since 7.5.2
 */
public interface I_CmsWebformActionHandler {

    /**
     * Runs the action after the web form was sent.<p>
     * 
     * @param cmsObject the current users context
     * @param formHandler the initialized web form handler
     * 
     */
    void afterWebformAction(CmsObject cmsObject, CmsFormHandler formHandler);
}
