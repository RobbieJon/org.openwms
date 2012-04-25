/*
 * openwms.org, the Open Warehouse Management System.
 *
 * This file is part of openwms.org.
 *
 * openwms.org is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * openwms.org is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software. If not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.openwms.wms.domain.receiving;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.openwms.wms.domain.order.AbstractOrder;

/**
 * A ReceivingOrder.
 * 
 * @author <a href="mailto:scherrer@openwms.org">Heiko Scherrer</a>
 * @version $Revision: $
 * @since 0.1
 */
@Entity
@DiscriminatorValue(ReceivingOrder.ORDER_TYPE)
@NamedQueries({
        @NamedQuery(name = ReceivingOrder.NQ_FIND_ALL, query = "select ro from ReceivingOrder ro order by ro.orderId"),
        @NamedQuery(name = ReceivingOrder.NQ_FIND_WITH_ORDERID, query = "select ro from ReceivingOrder ro where ro.orderId = :"
                + ReceivingOrder.QP_FIND_WITH_ORDERID_ORDERID) })
public class ReceivingOrder extends AbstractOrder {

    private static final long serialVersionUID = 8539054444807601298L;
    /** Order type, default: {@value} */
    public static final String ORDER_TYPE = "RECEIVING";
    /**
     * Query to find all <code>ReceivingOrder</code>s.<br />
     * Query name is {@value} .
     */
    public static final String NQ_FIND_ALL = "ReceivingOrder.findAll";
    /**
     * Query to find an <code>ReceivingOrder</code>s by it's
     * <code>orderId</code> . <li>
     * Query parameter name <strong>{@value #QP_FIND_WITH_ORDERID_ORDERID}
     * </strong> : The orderId of the <code>ReceivingOrder</code> to search for.
     * </li> <br />
     * Query name is {@value} .
     */
    public static final String NQ_FIND_WITH_ORDERID = "ReceivingOrder.findWithOrderId";
    public static final String QP_FIND_WITH_ORDERID_ORDERID = "orderId";

    /**
     * Create a new ReceivingOrder.
     * 
     * @param ordId
     */
    public ReceivingOrder(String ordId) {
        super(ordId);
    }

    /**
     * Used by the JPA provider.
     */
    protected ReceivingOrder() {}
}