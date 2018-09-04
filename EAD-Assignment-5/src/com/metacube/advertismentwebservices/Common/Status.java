package com.metacube.advertismentwebservices.Common;

/**
 * Enums for different result status inserted , if data is inserted in
 * respective tables updated if data is successfully updated in tables deleted
 * if data is successfully deleted from table duplicate if data which user
 * trying to insert is already in table not_found for data which user is trying
 * to manipulate is not found in tables invalid if no category given for
 * advertisement doesn't exist error if there is some error in authorization
 */
public enum Status {
	INSERTED, UPDATED, DELETED, DUPLICATE, NOT_FOUND, INVALID, ERROR;
}