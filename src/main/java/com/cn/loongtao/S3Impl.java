package com.cn.loongtao;

import java.io.File;

import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class S3Impl implements S3 {

	public static AmazonS3 s3;

	/**
	 * 设置s3所在区域
	 * 
	 * @param region
	 * @return
	 */
	public static AmazonS3 setS3(Region region) {
		s3 = new AmazonS3Client();
		s3.setRegion(region);
		return s3;
	}

	public Bucket createBucket(String bucketName) {
		System.out.println("Creating bucket " + bucketName + "\n");
		return s3.createBucket(bucketName);
	}

	public void putObject(String bucketName, String key, File file) {
		System.out.println("Uploading a new object to S3 from a file\n");
		s3.putObject(new PutObjectRequest(bucketName, key, file));
	}

	public S3Object getObject(String bucketName, String key) {
		System.out.println("Downloading an object");
		return s3.getObject(new GetObjectRequest(bucketName, key));
	}

	public ObjectListing listObjects(String bucketName, String prefix) {
		System.out.println("Listing objects");
		return s3.listObjects(new ListObjectsRequest().withBucketName(bucketName).withPrefix(prefix));
	}

}
