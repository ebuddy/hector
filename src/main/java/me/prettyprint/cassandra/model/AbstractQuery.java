package me.prettyprint.cassandra.model;

import me.prettyprint.cassandra.utils.Assert;

public abstract class AbstractQuery<N,V,T> implements Query<T>{

  protected final KeyspaceOperator keyspaceOperator;
  protected String columnFamilyName;
  protected final Extractor<N> columnNameExtractor;
  protected final Extractor<V> valueExtractor;


  /*package*/ AbstractQuery(KeyspaceOperator ko, Extractor<N> nameExtractor,
      Extractor<V> valueExtractor) {
    Assert.noneNull(ko, nameExtractor, valueExtractor);
    keyspaceOperator = ko;
    this.columnNameExtractor = nameExtractor;
    this.valueExtractor = valueExtractor;
  }

  public AbstractQuery<N,V,T> setColumnFamily(String cf) {
    this.columnFamilyName = cf;
    return this;
  }
}
