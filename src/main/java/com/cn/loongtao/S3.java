package com.cn.loongtao;

import java.io.File;

import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;

/**
 * 针对S3的一些常规操作
 * @author loongtao
 *
 */
public interface S3 {

	/**
	 * 根据桶名创建桶
	 * @param bucketName
	 * @return 创建的桶对象
	 */
	public Bucket createBucket(String bucketName);
	
	/**
	 * 上传文件到s3中
	 * @param bucketName 文件要上传到的桶名
	 * @param key 文件上传到桶里后的文件名
	 * @param file 要上传到s3上的文件
	 */
	public void putObject(String bucketName , String key , File file);
	
	/**
	 * 从s3中获取指定文件
	 * @param bucketName
	 * @param key 文件名
	 * @return
	 */
	public S3Object getObject(String bucketName , String key);
	
	/**
	 * 根据前缀获取文件
	 * @param bucketName
	 * @param prefix 文件名中的前缀
	 * @return
	 */
	public ObjectListing listObjects(String bucketName , String prefix);
	
	
	
}
