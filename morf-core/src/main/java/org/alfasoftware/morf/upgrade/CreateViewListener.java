package org.alfasoftware.morf.upgrade;

import org.alfasoftware.morf.metadata.View;

import com.google.common.collect.ImmutableList;
import com.google.inject.ImplementedBy;

/**
 *
 * Listener for calls to {@link ViewChangesDeploymentHelper#createView(View)}.
 *
 * @author Copyright (c) Alfa Financial Software Limited. 2021
 */
@ImplementedBy(CreateViewListener.NoOp.class)
public interface CreateViewListener {

  /**
   * Called during {@link ViewChangesDeploymentHelper#createView(View)}.
   *
   * @param view View being created.
   * @return Should return statements to be part of view creation, after the view has been created.
   */
  public Iterable<String> registerView(View view);


  /**
   * Empty implementation.
   */
  class NoOp implements CreateViewListener {

    @Override
    public Iterable<String> registerView(View view) {
      return ImmutableList.of();
    }
  }
}
