import React, { FC } from 'react';
import { EntityRendererProps } from 'app/litho-ui/mydata/resources/_shared/EntityRendererProps';

export const composeEntityListRenderer = (entity2name: any): FC<EntityRendererProps> => (props: EntityRendererProps) => {
  return <span>{entity2name(props.data)}</span>;
};
