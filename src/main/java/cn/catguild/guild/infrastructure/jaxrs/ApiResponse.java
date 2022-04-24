package cn.catguild.guild.infrastructure.jaxrs;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author xiyan
 * @date 2022-03-12 17:49
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ApiResponse<T> {
	/**
	 * 如果请求成功
	 */
	private boolean success;
	/**
	 * 响应数据
	 */
	private T data;
	/**
	 * 错误类型代码
	 */
	private String errorCode;
	/**
	 * 向用户显示消息
	 */
	private String errorMessage;
	/**
	 * 错误显示类型： 0 无声； 1条消息。警告； 2 message.error; 4 通知； 9 页
	 */
	private Integer showType;
	/**
	 * 方便后端排查：唯一的请求ID
	 */
	private String traceId;
	/**
	 * 方便后端排查：当前接入服务器的主机
	 */
	private String host;

	public ApiResponse() {
	}

	public ApiResponse(boolean success, T data, String errorCode, String errorMessage, Integer showType, String traceId, String host) {
		this.success = success;
		this.data = data;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.showType = showType;
		this.traceId = traceId;
		this.host = host;
	}

	public ApiResponse(String errorCode) {
		this(false, null, errorCode, null, null, null, null);
	}

	public ApiResponse(T data) {
		this(true, data, null, null, null, null, null);
	}

	/**
	 * 正常响应
	 *
	 * @param data
	 * @param <T>
	 * @return
	 */
	public static <T> ApiResponse<T> ok(T data) {
		return new ApiResponse<>(data);
	}

	public static <T> ApiResponse<T> ok() {
		ApiResponse<T> objectApiResponse = new ApiResponse<T>();
		objectApiResponse.setSuccess(true);
		return objectApiResponse;
	}

	/**
	 * 错误响应
	 *
	 * @param errorCode 响应码
	 * @param <T>
	 * @return
	 */
	public static <T> ApiResponse<T> fail(String errorCode) {
		return new ApiResponse<>(errorCode);
	}

	public static <T> ApiResponse<T> fail() {
		return new ApiResponse<>("400");
	}

	public static ApiResponse<?> status(Boolean status) {
		return status != null && status ? ok() : fail();
	}

}
