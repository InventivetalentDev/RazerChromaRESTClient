package org.inventivetalent.chromaclient.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseResults {

	private List<ResponseResult> results = new ArrayList<ResponseResult>();

}
