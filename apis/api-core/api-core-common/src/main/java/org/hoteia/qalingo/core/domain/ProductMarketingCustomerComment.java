/**
 * Most of the code in the Qalingo project is copyrighted Hoteia and licensed
 * under the Apache License Version 2.0 (release version 0.7.0)
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *                   Copyright (c) Hoteia, 2012-2013
 * http://www.hoteia.com - http://twitter.com/hoteia - contact@hoteia.com
 *
 */
package org.hoteia.qalingo.core.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TECO_PRODUCT_MARKETING_CUSTOMER_COMMENT")
public class ProductMarketingCustomerComment extends AbstractAddress {

	/**
	 * Generated UID
	 */
    private static final long serialVersionUID = 1424510557043858148L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="COMMENT")
    private String comment;

	@Column(name="PRODUCT_MARKETING_CUSTOMER_COMMENT_ID")
	private Long productMarketingCustomerCommentId;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name="CUSTOMER_ID")
	private Customer customer;

    @Column(name="MARKET_AREA_ID")
    private Long marketAreaId;

    @Column(name="PRODUCT_MARKETING_ID")
    private Long productMarketingId;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="PRODUCT_MARKETING_CUSTOMER_COMMENT_ID")
	private Set<ProductMarketingCustomerComment> customerComments = new HashSet<ProductMarketingCustomerComment>(); 
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_CREATE")
	private Date dateCreate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_UPDATE")
	private Date dateUpdate;
	
	public ProductMarketingCustomerComment() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getComment() {
    	return comment;
    }

	public void setComment(String comment) {
    	this.comment = comment;
    }

	public Long getProductMarketingCustomerCommentId() {
        return productMarketingCustomerCommentId;
    }
	
	public void setProductMarketingCustomerCommentId(Long productMarketingCustomerCommentId) {
        this.productMarketingCustomerCommentId = productMarketingCustomerCommentId;
    }

	public Customer getCustomer() {
    	return customer;
    }

	public void setCustomer(Customer customer) {
    	this.customer = customer;
    }
	
	public Long getMarketAreaId() {
        return marketAreaId;
    }
	
	public void setMarketAreaId(Long marketAreaId) {
        this.marketAreaId = marketAreaId;
    }

	public Long getProductMarketingId() {
        return productMarketingId;
    }
	
	public void setProductMarketingId(Long productMarketingId) {
        this.productMarketingId = productMarketingId;
    }
	
	public Set<ProductMarketingCustomerComment> getCustomerComments() {
    	return customerComments;
    }

	public void setCustomerComments(Set<ProductMarketingCustomerComment> customerComments) {
    	this.customerComments = customerComments;
    }

	public Date getDateCreate() {
    	return dateCreate;
    }

	public void setDateCreate(Date dateCreate) {
    	this.dateCreate = dateCreate;
    }

	public Date getDateUpdate() {
    	return dateUpdate;
    }

	public void setDateUpdate(Date dateUpdate) {
    	this.dateUpdate = dateUpdate;
    }

}