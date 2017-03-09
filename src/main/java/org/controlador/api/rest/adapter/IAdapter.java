package org.controlador.api.rest.adapter;

import java.util.List;

public interface IAdapter<K, Y> {

	public K toDomain(Y dto);

	public Y toDto(K domain);

	public List<K> toListDomain(List<Y> dto);

	public List<Y> toListDto(List<K> domain);

}
