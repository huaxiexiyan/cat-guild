/*
 * Copyright 2012-2020. the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. More information from:
 *
 *        https://github.com/fenixsoft
 */

package cn.catguild.guild.infrastructure.persistence;

import cn.catguild.guild.domain.user.type.*;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * DO 基类
 *
 * @author xiyan
 * @date 2020/3/6 10:52
 **/
@Data
public class BaseEntity implements Serializable {

	/**
	 * 主键，默认使用雪花id
	 */
	@TableId(type = IdType.ASSIGN_ID)
	private Long id;
	/** 创建时间 **/
	private Long createdTime;
	/** 最后修改时间 **/
	private Long lastModifiedTime;

}
